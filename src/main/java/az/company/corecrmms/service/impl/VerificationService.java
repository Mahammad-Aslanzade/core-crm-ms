package az.company.corecrmms.service.impl;

import az.company.corecrmms.constant.Constants;
import az.company.corecrmms.entity.User;
import az.company.corecrmms.entity.UserVerification;
import az.company.corecrmms.exception.CommonException;
import az.company.corecrmms.exception.ExceptionEnum;
import az.company.corecrmms.repository.UserVerificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class VerificationService {

    private final UserVerificationRepository userVerificationRepository;
    private final EmailService emailService;

    @Transactional
    public void sendVerification(User user) {
        HashMap<String, String> variables = new HashMap<>();
        String verificationCode = generateCode();
        UserVerification userVerification = new UserVerification();
        userVerification.setVerificationCode(verificationCode);
        userVerification.setUser(user);
        userVerificationRepository.save(userVerification);

        // Email process
        emailService.sendEmail(user.getEmail(), Constants.VERIFICATION_EMAIL_SUBJECT, Constants.VERIFICATION_EMAIL_TEMPLATE_NAME, variables);
    }

    public void verifyAccount(User user, String verificationCode) {
        UserVerification verification = userVerificationRepository.findTopByUserOrderByCreatedAtDesc(user)
                .orElseThrow(() -> new CommonException(ExceptionEnum.USER_VERIFICATION_DETAILS_NOT_FOUND_EXCEPTION));

        if (!Objects.equals(verification.getVerificationCode(), verificationCode))
            throw new CommonException(ExceptionEnum.VERIFICATION_FAILED_EXCEPTION);
    }

    private String generateCode() {
        Random random = new Random();
        String code = String.valueOf(random.nextInt(100000, 999999));
        return String.format("%s-%s", code.subSequence(0, 3), code.subSequence(3, 6));
    }
}
