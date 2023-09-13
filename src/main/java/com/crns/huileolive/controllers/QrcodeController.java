package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Recipient;
import com.crns.huileolive.services.QrcodeService;
import com.crns.huileolive.services.RecipientService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

@Controller
public class QrcodeController {

    private final QrcodeService qrcodeService;
    private final RecipientService recipientService;

    @Autowired
    public QrcodeController(QrcodeService qrcodeService, RecipientService recipientService) {
        this.qrcodeService = qrcodeService;
        this.recipientService = recipientService;
    }

    @GetMapping("/api/generateQR/{recipientId}")
    public void generateQRCode(@PathVariable long recipientId, HttpServletResponse response) throws IOException {
        Optional<Recipient> optionalRecipient = recipientService.getRecipientById(recipientId);
        if (optionalRecipient.isPresent()) {
            Recipient recipient = optionalRecipient.get();
            try {
                BufferedImage qrCodeImage = qrcodeService.generateQRCodeImage(recipient, 200, 200);

                response.setContentType("image/png");
                ImageIO.write(qrCodeImage, "PNG", response.getOutputStream());
                response.getOutputStream().flush();
            } catch (com.google.zxing.WriterException e) {
                // Gérer l'exception ici
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
