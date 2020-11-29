<?php

namespace App\Entity;

use ApiPlatform\Core\Annotation\ApiResource;
use App\Repository\UserEducationRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ApiResource()
 * @ORM\Entity(repositoryClass=UserEducationRepository::class)
 */
class UserEducation
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
    private $university;

    /**
     * @ORM\Column(type="string", length=1000)
     */
    private $major;

    /**
     * @ORM\Column(type="string", length=4)
     */
    private $graduationYear;

    /**
     * @ORM\ManyToOne(targetEntity=UserProfile::class, inversedBy="userEducation")
     */
    private $userProfile;

    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return string|null
     */
    public function getUniversity(): ?string
    {
        return $this->university;
    }

    public function setUniversity(string $university): self
    {
        $this->university = $university;

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return string|null
     */
    public function getMajor(): ?string
    {
        return $this->major;
    }

    public function setMajor(string $major): self
    {
        $this->major = $major;

        return $this;
    }

    /**
     * @Groups({"user:item:get", "user:collection:get"})
     * @return string|null
     */
    public function getGraduationYear(): ?string
    {
        return $this->graduationYear;
    }

    public function setGraduationYear(string $graduationYear): self
    {
        $this->graduationYear = $graduationYear;

        return $this;
    }

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
