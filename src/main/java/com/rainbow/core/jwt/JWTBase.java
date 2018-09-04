package com.rainbow.core.jwt;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rainbow.common.Constants;
import com.rainbow.common.util.PropertiesFactory;

/**
 * core code for JWT
 * 
 * @author Ray
 * 
 */
public class JWTBase {
	final static Logger logger = LogManager.getLogger(JWTBase.class);

	private static final String SECRET = "QU1ZSVNNWUJBQllHSVJM";
	private static JWTVerifier verifier = null;

	public static String createToken(Map<String, String> claims) {
		String token = null;
		try {
			Builder jwtBuilder = JWT.create();
			jwtBuilder = appendClaims(jwtBuilder, claims);
			token = jwtBuilder.sign(Algorithm.HMAC256(SECRET));
		} catch (JWTCreationException e) {
			logger.error("Create JWT Error : ", e);
		} catch (IllegalArgumentException e) {
			logger.error("Create JWT Error : ", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Create JWT Error : ", e);
		}

		return token;
	}

	private static Builder appendClaims(Builder builder, Map<String, String> claims) {

		builder.withIssuer(PropertiesFactory.getConfig(Constants.CONFIG_PROPERTIES_JWT_ISSUER));

		if (claims != null) {
			for (String key : claims.keySet()) {
				if (claims.get(key) != null) {
					builder.withClaim(key, claims.get(key));
				}
			}
		}
		return builder;
	}

	public static DecodedJWT verifyToken(String token) {
		DecodedJWT jwt = null;
		try {
			if (verifier == null) {
				verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
			}

			jwt = verifier.verify(token);

		} catch (JWTVerificationException e) {
			logger.info("Token Verify failed. Token : " + token);
		} catch (IllegalArgumentException e) {
			logger.error("Verify JWT Error : ", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Verify JWT Error : ", e);
		}

		return jwt;
	}

}
