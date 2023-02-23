package com.chatgpt.android;

import java.util.HashMap;

public class AppConstants {

    static {
        System.loadLibrary("keys");
    }

    public static native String getDevBaseUrl();
    public static native String getDevApiKey();
    public static native String getDevBearerAuthenticationToken();

    public static native String getProdBaseUrl();
    public static native String getProdApiKey();
    public static native String getProdBearerAuthenticationToken();

    public static final class AppConfig {
        public static final String APP_NAME     = "ChatGPT";
        public static final String PACKAGE_NAME = BuildConfig.APPLICATION_ID;
        public static final int VERSION_CODE    = BuildConfig.VERSION_CODE;
        public static final String VERSION_NAME = BuildConfig.VERSION_NAME;
        public static final boolean IS_DEBUG    = BuildConfig.DEBUG;
    }

    public static final class AppSupport {
        public static final String LOCATION             = "Indore";
        public static final String MAIL                 = "support@gmail.com";
        public static final String MOBILE               = "917898680304";
        public static final String TERMS_AND_CONDITIONS = "terms_and_conditions";
        public static final String PRIVACY_POLICY       = "privacy_policy";
    }

    public static final class ApiInfo {
        public static final class Development {
            public static final String BASE_URL                     = getDevBaseUrl();
            public static final String API_KEY                      = getDevApiKey();
            public static final String BEARER_AUTHENTICATION_TOKEN  = getDevBearerAuthenticationToken();
        }

        public static final class Production {
            public static final String BASE_URL                     = getProdBaseUrl();
            public static final String API_KEY                      = getProdApiKey();
            public static final String BEARER_AUTHENTICATION_TOKEN  = getProdBearerAuthenticationToken();
        }
    }

    public static final class Delay {
        public static final int SPLASH   = 1000 * 2;
        public static final int API_CALL = 1000 * 5; /* api call time, every 5 seconds api call*/
        public static final int SHIMMER  = 1000 * 2;
    }

    public static final class RequestCode {
        public static final int CAPTURE_IMAGE = 0x001;
        public static final int CAPTURE_VIDEO = 0x002;
    }

    public static final class Extras {
        public static final String LATITUDE        = "LATITUDE";
        public static final String LONGITUDE       = "LONGITUDE";
        public static final String LAT_LON_ADDRESS = "LAT_LON_ADDRESS";
    }

    public static final class Screen {
        public static final class Key {
            public static final String NAVIGATE_TO   = "navigate_to";
            public static final String TITLE         = "title";
            public static final String MESSAGE       = "message";
            public static final String ORDER_TYPE    = "order_type";
            public static final String ORDER_ID      = "order_id";
            public static final String DATA_REQUIRED = "data_required";
        }

        public static final class Extras {
            public static final String NAVIGATE_TO    = "NAVIGATE_TO";
            public static final String TITLE          = "TITLE";
            public static final String MESSAGE        = "MESSAGE";
            public static final String ORDER_TYPE     = "ORDER_TYPE";
            public static final String ORDER_ID       = "ORDER_ID";
            public static final String DATA_REQUIRED  = "DATA_REQUIRED";
        }
    }

    public static final class SharedPreferences {
        public static final String SHARED_PREFERENCES_FILE_NAME = AppConfig.APP_NAME + "SharedPrefs";

        public static final String CURRENT_THEME                = "current_theme";

        public static final String IS_LANGUAGE_SELECT           = "is_language_select";
        public static final String CURRENT_LANGUAGE             = "current_language";

        public static final String IS_SHOW_APP_INTRO            = "is_show_app_intro";

        public static final String REMEMBER_ME                  = "remember_me";

        public static final String USER_ID                      = "id";
        public static final String OS                           = "os";
        public static final String PICTURE                      = "picture";
        public static final String NAME                         = "name";
        public static final String EMAIL                        = "email";
        public static final String PHONE_NUMBER                 = "phone_number";
        public static final String PASSWORD                     = "password";
        public static final String LATITUDE                     = "latitude";
        public static final String LONGITUDE                    = "longitude";
        public static final String LAT_LON_ADDRESS              = "lat_lon_address";
        public static final String CATEGORY_ID                  = "category_id";
        public static final String CATEGORY_NAME                = "category_name";
        public static final String SUB_CATEGORY_ID              = "sub_category_id";
        public static final String SUB_CATEGORY_NAME            = "sub_category_name";
        public static final String ABOUT_YOU                    = "about_you";
        public static final String GALLERY                      = "gallery";
        public static final String AADHAAR_CARD_FRONT           = "aadhaar_card_front";
        public static final String AADHAAR_CARD_BACK            = "aadhaar_card_back";
        public static final String PAN_CARD                     = "pan_card";
        public static final String IS_ACTIVE                    = "is_active";
        public static final String IS_ONLINE                    = "is_online";
        public static final String CREDIT                       = "credit";
        public static final String FCM_TOKEN                    = "fcm_token";
        public static final String CREATED_AT                   = "created_at";
        public static final String UPDATED_AT                   = "updated_at";
    }

    public static final class Database {
        public static final String SQLITE_DATABASE_FILE_NAME    = AppConfig.APP_NAME + "SQLite.db";
        public static final int SQLITE_VERSION                  = 1;

        public static final String ROOM_DATABASE_FILE_NAME      = AppConfig.APP_NAME + "Room.db";
        public static final int ROOM_VERSION                    = 1;
    }

    public static final class Firebase {
        /**
         * FCM Endpoint for sending messages.
         */
        public static final String FCM                          = "https://fcm.googleapis.com/fcm/send";
        public static final String AUTHORIZATION_KEY            = "Authorization";
        public static final String FIREBASE_SERVER_KEY          = BuildConfig.FIREBASE_SERVER_KEY;
        public static final String AUTHORIZATION_KEY_VALUE      = "key=" + FIREBASE_SERVER_KEY;
        public static final String CONTENT_TYPE_KEY             = "Content-Type";
        public static final String CONTENT_TYPE_VALUE_JSON      = "application/json";

        public static HashMap<String,String> getFCMHeader() {
            HashMap<String,String> headers=new HashMap<>();
            headers.put(AUTHORIZATION_KEY, AUTHORIZATION_KEY_VALUE);
            headers.put(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE_JSON);
            return headers;
        }

        public static final String KYE_TO                       = "to";
        public static final String KYE_REGISTRATION_IDS         = "registration_ids";
        public static final String KYE_NOTIFICATION_PAYLOAD     = "notification";
        public static final String KYE_DATA_PAYLOAD             = "data";
    }

    public static final class Chat {
        public static final class OneToOne {
            public static final String SENDER_ID    = "sender_id";
            public static final String RECEIVER_ID  = "receiver_id";
            public static final String MESSAGE      = "message";
            public static final String MESSAGE_TYPE = "message_type";
            public static final String DATE         = "date";
            public static final String TIME         = "time";
            public static final String SEEN         = "seen";
        }

        public static final class Group {
            public static final String SENDER_ID              = "sender_id";
            public static final String SENDER_NAME            = "sender_name";
            public static final String SENDER_PROFILE_PICTURE = "sender_profile_picture";
            public static final String MESSAGE                = "message";
            public static final String MESSAGE_TYPE           = "message_type";
            public static final String DATE                   = "date";
            public static final String TIME                   = "time";
            public static final String SEEN                   = "seen";
        }
    }

    public static final class Call {
        public static final class Voice {
            public static final String TOKEN    = "91bHHE7wL2_uyYmGdlke_1jazgVWVU0wlcOToqPMVTYDE_DJ5isTIbPnXm";
        }

        public static final class Video {
            public static final String TOKEN    = "91bHHE7wL2_uyYmGdlke_1jazgVWVU0wlcOToqPMVTYDE_DJ5isTIbPnXm";
        }
    }

    public static final class AssetsPath {
        public static final String LOTTIE_PATH  = "assets/lottie/";
    }
}
