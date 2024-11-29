package es.deusto.sd.strava.external;

import es.deusto.sd.strava.entity.TipoLogin;

public class LoginServiceFactory {
    public ILoginServiceGateway getLoginServiceGateway(TipoLogin tipoLogin) {
		switch (tipoLogin) {
		case GOOGLE:
			return new GoogleServiceGateway();
//		case META:
//			return new MetaServiceGateway();
		default:
			return null;
		}
	}
}
