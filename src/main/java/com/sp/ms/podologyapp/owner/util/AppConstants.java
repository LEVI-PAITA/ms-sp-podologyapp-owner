package com.sp.ms.podologyapp.owner.util;

public final class AppConstants {

    private AppConstants() {}

    public static final String STORAGE_BONO_LIST_PARTITION_KEY = "1";

    /*Controller message*/
    public static final String LOG_KEY_GETAVAILABLEPROMOTIONS = "getAvailablePromotions";

    public static final String LOG_KEY_CANJEAR_BONO = "canjearBono";

    public static final String LOG_MESSAGE_CONTROLLER_ERROR = "Error en Controller";

    public static final String LOG_MESSAGE_REQUEST_FRONT = "Se guarda el request del front";

    public static final String LOG_MESSAGE_RESPONSE_OK = "Se guarda el response del front - OK";

    public static final String LOG_MESSAGE_RESPONSE_ERROR = "Se guarda el response del front - ERROR";

    /*Rest message*/
    public static final String LOG_KEY_UPDATE_PROMOTION = "updatePromotion";

    public static final String LOG_KEY_RETRIEVE_PROMOTION = "retrieveAvailablePromotions";

    public static final String LOG_KEY_PRODUCT_INVENTORY = "productInventory";

    public static final String LOG_MESSAGE_REST_REQUEST = "Se guarda el request del API";

    public static final String LOG_MESSAGE_REST_OK = "Se guarda el response del API - OK";

    public static final String LOG_MESSAGE_REST_ERROR = "Se guarda el response del API - ERROR";

    public static final String LOG_MESSAGE_REST_TOKEN_ERROR = "Hubo un error en la generación de token";

    /*Service message*/

    public static final String LOG_MESSAGE_SERVICE_REQUIRED = "No existe el campo requerido";

    public static final String LOG_MESSAGE_SERVICE_ERROR = "Error en Service";

    /*Others*/
    public static final String HYPHEN = "-";

    public static final String COLON = ":";

    public static final String TIME_ZONE = "America/Lima";

    public static final String TOKEN_OAUTH_BEARER = "Bearer";

    public static final String SPACE = " ";

    public static final String CAMPAIGN_MC_TYPE = "BLINDAJE";

    public static final String CAMPAIGN_SUBSCRIBER = "subscriberId";

    public static final String HEADER_CLIENT_ID = "X-IBM-Client-Id";

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static final String DEFAULT_PHONE_NUMBER = "999999999";
    
    public static final String MESSAGE_EXITO = "Se registro exitosamente";
}
