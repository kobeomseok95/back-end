package com.project.devidea.modules.account.repository;

import com.project.devidea.modules.account.domains.Account;

public interface AccountRepositoryCustom {

    Account findByEmailWithMainActivityZoneAndInterests(String email);

    Account findByNicknameWithMainActivityZoneAndInterests(String nickname);

    Account findByEmailWithInterests(String email);

    Account findByEmailWithMainActivityZones(String email);

    Account findByTokenWithMainActivityZoneAndInterests(String token);
}
