package riwi.lastfilter.spring.infrastructure.abstrasct_services;

public interface IUpdate<Req, Res, Id> {

    public Res update(Req request, Id id);

}