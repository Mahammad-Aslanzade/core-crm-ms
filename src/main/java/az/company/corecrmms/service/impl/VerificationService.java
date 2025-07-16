package az.company.corecrmms.service.impl;

import az.company.corecrmms.constant.Constants;
import az.company.corecrmms.entity.User;
import az.company.corecrmms.entity.UserVerification;
import az.company.corecrmms.repository.UserVerificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class VerificationService {

    private final UserVerificationRepository userVerificationRepository;
    private final EmailService emailService;

    public void sendVerification(User user) {
        HashMap<String, String> variables = new HashMap<>();
        emailService.sendEmail(user.getEmail(), Constants.VERIFICATION_EMAIL_SUBJECT, Constants.VERIFICATION_EMAIL_TEMPLATE_NAME, variables);
    }

    public void verifyAccount(User user) {
        UserVerification verification = userVerificationRepository.findTopByUserAndCreatedAtDesc(user).orElseThrow();
    }
}
