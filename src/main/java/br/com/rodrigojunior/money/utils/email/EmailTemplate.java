package br.com.rodrigojunior.money.utils.email;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class EmailTemplate {

    public static String generateEmailConfirmationHtml(String name, String code) {
        // Get current year
        int currentYear = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).getYear();

        // Generate HTML email content
        String html = "<table class=\"x_body\" width=\"100%\" bgcolor=\"#fff\" style=\"background-color:#fff; min-width:600px\">\n" +
                "    <tbody>\n" +
                "      <tr>\n" +
                "        <td class=\"x_body\" align=\"center\" valign=\"top\" width=\"100%\" style=\"min-width:600px\">\n" +
                "          <center>\n" +
                "            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"x_body\" bgcolor=\"#fff\"\n" +
                "              style=\"min-width:500px\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td align=\"center\">\n" +
                "                    <table>\n" +
                "                      <tbody>\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\"\n" +
                "                            style=\" font-size:26px; color:#313131; line-height:32px\">\n" +
                "                            &nbsp;</td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">&nbsp;</td>\n" +
                "                        </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "                    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"x_body\" style=\"min-width:500px\">\n" +
                "                      <tbody>\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">\n" +
                "                            <table width=\"500\" class=\"x_panel\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                              style=\"min-width:500px\">\n" +
                "                              <tbody>\n" +
                "                                <tr>\n" +
                "                                  <td width=\"100%\" height=\"50\" style=\"line-height:1px; font-size:1px\">\n" +
                "                                    <div\n" +
                "                                      style=\" color: rgb(32, 32, 32); text-align: center; font-size: 26px; line-height: 100%; letter-spacing: 2px;\">\n" +
                "                                      Seu código de verificação: </div>\n" +
                "                                  </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                  <td width=\"100%\" height=\"50\" style=\"line-height:1px; font-size:1px\">\n" +
                "                                    <div\n" +
                "                                      style=\" color: rgb(32, 32, 32); text-align: center; font-size: 26px; line-height: 100%; letter-spacing: 2px;\">\n" +
                "                                      <b>" + code + "</b> </div>\n" +
                "                                  </td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"x_body\"\n" +
                "                              style=\"min-width:500px\">\n" +
                "                              <tbody>\n" +
                "                                <tr height=\"40\">\n" +
                "                                  <td align=\"center\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table width=\"500\" class=\"x_panel-padded\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "              style=\"background-color:#fff; margin:0 auto\">\n" +
                "              <tbody>\n" +
                "                <tr height=\"50\">\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                  <td height=\"50\" style=\"line-height:1px; font-size:1px\">&nbsp;</td>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                  <td align=\"left\"\n" +
                "                    style=\" font-size:14px; color:#202020; line-height:19px; line-height:134%; letter-spacing:.5px\">\n" +
                "                    Hello, " + name + ", <br aria-hidden=\"true\"><br aria-hidden=\"true\"></td>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                  <td align=\"left\"\n" +
                "                    style=\" font-size:14px; color:#202020; line-height:19px; line-height:134%; letter-spacing:.5px\">\n" +
                "                    Congratulations, you have completed your registration. To complete your login, please use the code above.</td>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table width=\"500\" class=\"x_panel-padded\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "              style=\"min-width:400px; background-color:#fff\">\n" +
                "              <tbody>\n" +
                "                <tr height=\"50\">\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                  <td height=\"50\" style=\"line-height:1px; font-size:1px\">&nbsp;</td>\n" +
                "                  <td width=\"50\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"x_body\" style=\"min-width:500px\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td align=\"center\">\n" +
                "                    <table width=\"500\" class=\"x_panel\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width:500px\">\n" +
                "                      <tbody>\n" +
                "                        <tr height=\"30\">\n" +
                "                          <td width=\"100%\" height=\"20\" style=\"line-height:1px; font-size:1px\">&nbsp;</td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\" class=\"x_panel-padded\">\n" +
                "                            <div\n" +
                "                              style=\"font-family: arial, helvetica, sans-serif, serif, EmojiFont; font-size: 10px; color: rgb(32, 32, 32); text-align: center; line-height: 12px;\">\n" +
                "                              <p>© " + currentYear + " Posto Brigadeiro. All rights reserved. </p>\n" +
                "                            </div>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                        <tr height=\"30\">\n" +
                "                          <td width=\"100%\" height=\"30\" style=\"line-height:1px; font-size:1px\">&nbsp;</td>\n" +
                "                        </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "          </center>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>";

        return html;
    }

}
