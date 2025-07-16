package az.company.corecrmms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class EmailService {

    public void sendEmail(String email, String subject, String templateName, HashMap<String, String> variables) {
        // TODO
    }

}
