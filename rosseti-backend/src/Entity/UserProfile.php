<?php

namespace App\Entity;

use ApiPlatform\Core\Annotation\ApiResource;
use App\Repository\UserProfileRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ApiResource()
 * @ORM\Entity(repositoryClass=UserProfileRepository::class)
 */
class UserProfile
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="integer")
     */
    private $rating;

    /**
     * @ORM\OneToOne(targetEntity=User::class, cascade={"persist", "remove"})
     */
    private $user;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $position;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $department;

    /**
     * @ORM\Column(type="integer")
     */
    private $Experience;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $phone;

    /**
     * @ORM\OneToMany(targetEntity=UserEducation::class, mappedBy="userProfile")
     */
    private $userEducation;

    public function __construct()
    {
        $this->userEducation = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getRating(): ?int
    {
        return $this->rating;
    }

    public function setRating(int $rating): self
    {
        $this->rating = $rating;

        return $this;
    }

    public function getUser(): ?User
    {
        return $this->user;
    }

    public function setUser(?User $user): self
    {
        $this->user = $user;

        return $this;
    }

    public function getPosition(): ?string
    {
        return $this->position;
    }

    public function setPosition(string $position): self
    {
        $this->position = $position;

        return $this;
    }

    public function getDepartment(): ?string
    {
        return $this->department;
    }

    public function setDepartment(string $department): self
    {
        $this->department = $department;

        return $this;
    }

    public function getExperience(): ?int
    {
        return $this->Experience;
    }

    public function setExperience(int $Experience): self
    {
        $this->Experience = $Experience;

        return $this;
    }

    public function getPhone(): ?string
    {
        return $this->phone;
    }

    public function setPhone(string $phone): self
    {
        $this->phone = $phone;

        return $this;
    }

    /**
     * @return Collection|UserEducation[]
     */
    public function getUserEducation(): Collection
    {
        return $this->userEducation;
    }

    public function addUserEducation(UserEducation $userEducation): self
    {
        if (!$this->userEducation->contains($userEducation)) {
            $this->userEducation[] = $userEducation;
            $userEducation->setUserProfile($this);
        }

        return $this;
    }

    public function removeUserEducation(UserEducation $userEducation): self
    {
        if ($this->userEducation->removeElement($userEducation)) {
            // set the owning side to null (unless already changed)
            if ($userEducation->getUserProfile() === $this) {
                $userEducation->setUserProfile(null);
            }
        }

        return $this;
    }
}
