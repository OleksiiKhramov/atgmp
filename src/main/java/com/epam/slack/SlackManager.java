package com.epam.slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import lombok.SneakyThrows;

public class SlackManager {

    public static String webHookUrl = "https://hooks.slack.com/services/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";
    public static String oAuthToker = "xoxb-5551224625712-5527539924466-8Djn5oP64f4cUFVeSuMH1jIt";
    public static String slackChannel = "report";

    @SneakyThrows
    public static void sendMessageToSlack(String message) {

        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(message);
        Payload payload = Payload.builder().channel(slackChannel).text(msgBuilder.toString()).build();
        WebhookResponse webhookResponse = Slack.getInstance().send(webHookUrl, payload);
    }
}
