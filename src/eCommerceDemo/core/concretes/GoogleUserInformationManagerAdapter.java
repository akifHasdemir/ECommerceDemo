package eCommerceDemo.core.concretes;

import eCommerceDemo.core.abstracts.GoogleUserInformationService;
import eCommerceDemo.jRegisterWithGoogleAccount.GoogleUserInformation;

public class GoogleUserInformationManagerAdapter implements GoogleUserInformationService {
    @Override
    public GoogleUserInformation getUserInfo() {
        GoogleUserInformation info = new GoogleUserInformation();
        return info;
    }
}
