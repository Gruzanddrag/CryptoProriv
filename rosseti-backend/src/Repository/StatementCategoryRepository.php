<?php

namespace App\Repository;

use App\Entity\StatementCategory;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method StatementCategory|null find($id, $lockMode = null, $lockVersion = null)
 * @method StatementCategory|null findOneBy(array $criteria, array $orderBy = null)
 * @method StatementCategory[]    findAll()
 * @method StatementCategory[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class StatementCategoryRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, StatementCategory::class);
    }

    // /**
    //  * @return StatementCategory[] Returns an array of StatementCategory objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('s')
            ->andWhere('s.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('s.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?StatementCategory
    {
        return $this->createQueryBuilder('s')
            ->andWhere('s.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
