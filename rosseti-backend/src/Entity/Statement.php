<?php

namespace App\Entity;

use ApiPlatform\Core\Annotation\ApiResource;
use App\Repository\StatementRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ApiResource(
 *     collectionOperations={
 *          "get"={"normalization_context"={"groups"="statement:collection:get"}},
 *          "post"={"normalization_context"={"groups"="statement:item:get"}}
 *     },
 *     itemOperations={
 *          "get"={"normalization_context"={"groups"="statement:item:get"}},
 *          "put"={"normalization_context"={"groups"="statement:item:get"}}
 *     })
 * @ORM\Entity(repositoryClass=StatementRepository::class)
 * @ORM\HasLifecycleCallbacks()
 */
class Statement
{

    public const STATUS_SAVED = 0;
    public const STATUS_SENT_TO_MODERATOR = 1;
    public const STATUS_REJECTED = 2;
    public const STATUS_SENT_TO_COMMISSION = 3;
    public const STATUS_REJECTED_BY_MODERATOR = 4;
    public const STATUS_APPROVED = 5;

    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=1000)
     */
    private $name;

    /**
     * @ORM\ManyToOne(targetEntity=User::class, inversedBy="statements")
     */
    private $author;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $projectDescription;

    /**
     * @ORM\ManyToOne(targetEntity=StatementCategory::class, inversedBy="statements")
     */
    private $category;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $economicEffect;

    /**
     * @ORM\Column(type="integer")
     */
    private $status;

    /**
     * @ORM\Column(type="integer")
     */
    private $createdAt;

    /**
     * @ORM\Column(type="integer")
     */
    private $updatedAt;

    /**
     * @ORM\Column(type="boolean")
     */
    private $generatingSaving;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $newness;

    /**
     * @ORM\Column(type="integer")
     */
    private $upvotes;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $limitationsDescription;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $disadvantageDescription;

    /**
     * @ORM\Column(type="text", length=10000)
     */
    private $advantagesDescription;


    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return int|null
     */
    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return string|null
     */
    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        $this->name = $name;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return User|null
     */
    public function getAuthor(): ?User
    {
        return $this->author;
    }

    public function setAuthor(?User $author): self
    {
        $this->author = $author;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return string|null
     */
    public function getProjectDescription(): ?string
    {
        return $this->projectDescription;
    }

    public function setProjectDescription(string $projectDescription): self
    {
        $this->projectDescription = $projectDescription;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return StatementCategory|null
     */
    public function getCategory(): ?StatementCategory
    {
        return $this->category;
    }

    public function setCategory(?StatementCategory $category): self
    {
        $this->category = $category;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return string|null
     */
    public function getEconomicEffect(): ?string
    {
        return $this->economicEffect;
    }

    public function setEconomicEffect(string $economicEffect): self
    {
        $this->economicEffect = $economicEffect;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return StatementStatus
     */
    public function getStatus(): StatementStatus
    {
        return new StatementStatus($this->status);
    }

    public function setStatus(int $status): self
    {
        $this->status = $status;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return int|null
     */
    public function getCreatedAt(): ?int
    {
        return $this->createdAt;
    }

    public function setCreatedAt(int $createdAt): self
    {
        $this->createdAt = $createdAt;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return int|null
     */
    public function getUpdatedAt(): ?int
    {
        return $this->updatedAt;
    }

    public function setUpdatedAt(int $updatedAt): self
    {
        $this->updatedAt = $updatedAt;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return bool|null
     */
    public function getGeneratingSaving(): ?bool
    {
        return $this->generatingSaving;
    }

    public function setGeneratingSaving(bool $generatingSaving): self
    {
        $this->generatingSaving = $generatingSaving;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return string|null
     */
    public function getNewness(): ?string
    {
        return $this->newness;
    }

    public function setNewness(string $newness): self
    {
        $this->newness = $newness;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return int|null
     */
    public function getUpvotes(): ?int
    {
        return $this->upvotes;
    }

    public function setUpvotes(int $upvotes): self
    {
        $this->upvotes = $upvotes;

        return $this;
    }

    public function getLimitationsDescription(): ?string
    {
        return $this->limitationsDescription;
    }

    public function setLimitationsDescription(string $limitationsDescription): self
    {
        $this->limitationsDescription = $limitationsDescription;

        return $this;
    }

    public function getDisadvantageDescription(): ?string
    {
        return $this->disadvantageDescription;
    }

    public function setDisadvantageDescription(string $disadvantageDescription): self
    {
        $this->disadvantageDescription = $disadvantageDescription;

        return $this;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get"})
     * @return string|null
     */
    public function getAdvantagesDescription(): ?string
    {
        return $this->advantagesDescription;
    }

    public function setAdvantagesDescription(string $advantagesDescription): self
    {
        $this->advantagesDescription = $advantagesDescription;

        return $this;
    }

    /**
     * @ORM\PrePersist
     */
    public function setUpStatement(): void
    {
        $time = time();
        $this->createdAt = $time;
        $this->updatedAt = $time;
        $this->upvotes = 0;
        $this->status = self::STATUS_SAVED;
    }

    /**
     *
     * @ORM\PreUpdate()
     */
    public function setUpdatedAtValue(): void
    {
        $this->updatedAt = time();
    }
}
