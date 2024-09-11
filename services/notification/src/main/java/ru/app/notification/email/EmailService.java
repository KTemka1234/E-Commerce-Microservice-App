package ru.app.notification.email;

import static java.nio.charset.StandardCharsets.UTF_8;
import static ru.app.notification.email.EmailTemplates.ORDER_CONFIRMATION;
import static ru.app.notification.email.EmailTemplates.PAYMENT_CONFIRMATION;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.app.notification.kafka.order.Product;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
        String destinationEmail,
        String customerName,
        BigDecimal amount,
        String orderReference
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
            mimeMessage,
            MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name()
        );    
        messageHelper.setFrom("kurdikov.as@edu.spbstu.ru");

        final String templateName = PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> vars = new HashMap<>();
        vars.put("customerName", customerName);
        vars.put("amount", amount);
        vars.put("orderReference", orderReference);
        
        Context context = new Context();
        context.setVariables(vars);
        messageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);
            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to {} with template {}", destinationEmail, templateName);
        } catch (Exception e) {
            log.warn("WARNING - Failed to send email to {} with template {}", destinationEmail, templateName);
        }
    }

    @Async
    public void sendOrderConfirmationEmail(
        String destinationEmail,
        String customerName,
        BigDecimal amount,
        String orderReference,
        List<Product> products
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
            mimeMessage,
            MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name()
        );    
        messageHelper.setFrom("kurdikov.as@edu.spbstu.ru");

        final String templateName = ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> vars = new HashMap<>();
        vars.put("customerName", customerName);
        vars.put("totalAmount", amount);
        vars.put("orderReference", orderReference);
        vars.put("products", products);
        
        Context context = new Context();
        context.setVariables(vars);
        messageHelper.setSubject(ORDER_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);
            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to {} with template {}", destinationEmail, templateName);
        } catch (Exception e) {
            log.warn("WARNING - Failed to send email to {} with template {}", destinationEmail, templateName);
        }
    }
}
