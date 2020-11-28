<?php


namespace App\Entity;


use Symfony\Component\Serializer\Annotation\Groups;

class StatementStatus
{
    private $status;

    public function __construct($status)
    {
        $this->setStatus($status);
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get","user:item:get", "user:collection:get"})
     * @param mixed $status
     */
    public function setStatus($status): void
    {
        $this->status = $status;
    }

    /**
     * @return mixed
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * @Groups({"statement:item:get", "statement:collection:get","user:item:get", "user:collection:get"})
     * @return string
     */
    public function getStatusName(): string
    {
        return $this->getStatusNames()[$this->status] ?? 'Не определено';
    }

    public function getStatusNames() {
        return [
            Statement::STATUS_APPROVED => 'Принято',
            Statement::STATUS_REJECTED => 'Отклонено',
            Statement::STATUS_REJECTED_BY_MODERATOR => 'Отклонено для доработки',
            Statement::STATUS_SAVED => 'Сохранено',
            Statement::STATUS_SENT_TO_COMMISSION => 'Отправлено в коммисию',
            Statement::STATUS_SENT_TO_MODERATOR => 'Отправлено на первичную проверку',
        ];
    }
}