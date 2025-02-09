package com.project.devidea.modules.account.services.signUpDetail;

import com.project.devidea.modules.account.domains.Account;
import com.project.devidea.modules.account.domains.Interest;
import com.project.devidea.modules.account.domains.MainActivityZone;
import com.project.devidea.modules.account.dto.SignUp;
import com.project.devidea.modules.account.repository.AccountRepository;
import com.project.devidea.modules.account.services.interest.InterestService;
import com.project.devidea.modules.account.services.mainActivityZone.MainActivityZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpDetailServiceImpl implements SignUpDetailService{

    private final AccountRepository accountRepository;
    private final MainActivityZoneService mainActivityZoneService;
    private final InterestService interestService;

    @Override
    public void saveSignUpDetail(SignUp.DetailRequest request) {

        Account account = accountRepository.findByTokenWithMainActivityZoneAndInterests(request.getToken());

        Set<MainActivityZone> mainActivityZones =
                mainActivityZoneService.getMainActivityZones(request.splitCitiesAndProvinces(), account);

        Set<Interest> interests = interestService.getInterests(request.getInterests(), account);

        account.saveSignUpDetail(request, mainActivityZones, interests);

        mainActivityZoneService.saveAll(mainActivityZones);
        interestService.saveAll(interests);
    }
}
