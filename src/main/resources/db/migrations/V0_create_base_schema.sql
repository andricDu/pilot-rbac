create table casbin_rule
(
    id    serial
        primary key,
    ptype varchar(255),
    v0    varchar(255),
    v1    varchar(255),
    v2    varchar(255),
    v3    varchar(255),
    v4    varchar(255),
    v5    varchar(255),
    constraint casbin_rule_unique
        unique (v0, v1, v2, v3, v4)
);

create index ix_casbin_casbin_rule_v4
    on casbin_rule (v4);


