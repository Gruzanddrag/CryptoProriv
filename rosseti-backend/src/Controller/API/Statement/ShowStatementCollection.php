<?php


namespace App\Controller\API\Statement;


use App\Entity\Statement;
use App\Repository\StatementRepository;
use Doctrine\Common\Collections\Criteria;

class ShowStatementCollection
{
    /**
     * @var StatementRepository
     */
    private $statementRepository;

    public function __construct(StatementRepository $repository)
    {
        $this->statementRepository = $repository;
    }

    public function __invoke(): array
    {
        $criteria = new Criteria();
        $criteria->where(Criteria::expr()->neq('status', Statement::STATUS_SAVED));
        return $this->statementRepository->matching($criteria)->getValues();
    }
}