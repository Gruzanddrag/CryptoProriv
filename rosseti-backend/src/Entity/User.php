<?php

namespace App\Entity;

use ApiPlatform\Core\Annotation\ApiResource;
use App\Repository\UserRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ApiResource(
 *     collectionOperations={
 *          "get"={
 *              "normalization_context"={"groups"="user:collection:get"},
 *          },
 *          "post"={"normalization_context"={"groups"="user:item:get"}}
 *     },
 *     itemOperations={
 *          "get"={"normalization_context"={"groups"="user:item:get"}},
 *          "put"={"normalization_context"={"groups"="user:item:get"}},
 *     }))
 * @ORM\Entity(repositoryClass=UserRepository::class)
 */
class User
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=1000)
     */
    private $FIO;

    /**
     * @ORM\Column(type="json")
     */
    private $roles = [];

    /**
     * @ORM\OneToMany(targetEntity=Statement::class, mappedBy="author")
     */
    private $statements;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $surname;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $name;

    /**
     * @ORM\OneToOne(targetEntity=UserProfile::class, cascade={"persist", "remove"}, mappedBy="user")
     */
    private $userProfile;

    public function __construct()
    {
        $this->statements = new ArrayCollection();
    }

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
    public function getFIO(): ?string
    {
        return $this->FIO;
    }

    public function setFIO(string $FIO): self
    {
        $this->FIO = $FIO;

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return array|null
     */
    public function getRoles(): ?array
    {
        return $this->roles;
    }

    public function setRoles(array $roles): self
    {
        $this->roles = $roles;

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return Collection|Statement[]
     */
    public function getStatements(): Collection
    {
        return $this->statements;
    }

    public function addStatement(Statement $statement): self
    {
        if (!$this->statements->contains($statement)) {
            $this->statements[] = $statement;
            $statement->setAuthor($this);
        }

        return $this;
    }

    public function removeStatement(Statement $statement): self
    {
        if ($this->statements->removeElement($statement)) {
            // set the owning side to null (unless already changed)
            if ($statement->getAuthor() === $this) {
                $statement->setAuthor(null);
            }
        }

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return string|null
     */
    public function getSurname(): ?string
    {
        return $this->surname;
    }

    public function setSurname(string $surname): self
    {
        $this->surname = $surname;

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
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
     * @Groups({"user:item:get", "user:collection:get"})
     * @return UserProfile|null
     */
    public function getUserProfile(): ?UserProfile
    {
        return $this->userProfile;
    }

    public function setUserProfile(?UserProfile $userProfile): self
    {
        $this->userProfile = $userProfile;

        return $this;
    }
}
