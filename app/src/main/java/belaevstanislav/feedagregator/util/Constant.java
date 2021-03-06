package belaevstanislav.feedagregator.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import belaevstanislav.feedagregator.R;
import belaevstanislav.feedagregator.main.FeedAgregator;

// TODO много классов constant с общим предком в package?
public class Constant {
    private static final Context context = FeedAgregator.getContext();
    private static final Resources resources = context.getResources();
    private static final DisplayMetrics displayMetrics = resources.getDisplayMetrics();

    private static int getResolvedColor(int resourceId) {
        return ContextCompat.getColor(context, resourceId);
    }

    // TOAST
    public static final String TOAST_TWITTER_ALREADY_LOGIN_IN = resources.getString(R.string.toast_twitter_already_login_in);
    public static final String TOAST_VK_ALREADY_LOGIN_IN = resources.getString(R.string.toast_vk_already_login_in);

    // INTENTKEYS
    public static final String FEED_ITEM_POSITION_KEY = "position";
    public static final String FEED_ITEM_ID_KEY = "id";
    public static final String FEED_ITEM_IS_FULL_WAY = "is_full_way";

    // DATASERVICE
    public static final String DATASERVICE_ACTION = resources.getString(R.string.dataservice_action);
    public static final String DATASERVICE_COMMAND_KEY = "DataServiceCommand";
    public static final String DATASERVICE_MESSAGE_KEY = "NotificatorMessage";

    // SCREEN
    // public static final float SCREEN_HEIGHT_PX = displayMetrics.heightPixels;
    public static final float SCREEN_WIDTH_PX = displayMetrics.widthPixels;

    // STORAGE
    public static final long STORAGE_DEFAULT_LONG = 0L;
    public static final long STORAGE_DEFAULT_LAST_TWEET_ID = 0L;
    public static final boolean STORAGE_DEFAULT_IS_SAVE_NEWS = true;

    // FEEDSOURCE
    public static final int FEEDSOURCE_COUNT = 2;

    // DATABASE
    public static final String DATABASE_NAME = "UnReadFeedItem.db";
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_COMMON_INFORMATION_TABLE_NAME = "common_information";
    public static final String DATABASE_FEED_ITEM_BYTECODE_TABLE_NAME = "bytecode";
    public static final String DATABASE_KEY_TABLE_ID = "_id";
    public static final String DATABASE_KEY_TABLE_TIME = "time";
    public static final String DATABASE_KEY_TABLE_SOURCE = "source";
    public static final String DATABASE_KEY_TABLE_BYTECODE = "bytecode";

    // TWITTER
    public static final String TWITTER_API_KEY = resources.getString(R.string.twitter_api_key);
    public static final String TWITTER_API_SECRET = resources.getString(R.string.twitter_api_sercet);
    public static final Integer TWITTER_MAX_TWEETS_PER_PAGE = 20;
    public static final Integer TWITTER_FIRST_QUERY_PAGE_SIZE = 10;
    public static final SimpleDateFormat TWITTER_TIME_PATTERN = new SimpleDateFormat("EEE MMM dd HH:mm:ss +SSSS yyyy", Locale.ENGLISH);
    static {
        TWITTER_TIME_PATTERN.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    // VK
    public static final String VK_SCOPE = "wall, offline, friends";
    public static final String VK_KEY_DATE = "date";
    public static final String VK_KEY_SOURCE_ID = "source_id";
    public static final String VK_KEY_FROM_ID = "from_id";
    public static final String VK_KEY_NAME = "name";
    public static final String VK_KEY_FIRST_NAME = "first_name";
    public static final String VK_KEY_LAST_NAME = "last_name";
    public static final String VK_KEY_PHOTO_100 = "photo_100";
    public static final String VK_KEY_PHOTO_200 = "photo_200";
    public static final String VK_KEY_RESPONSE = "response";
    public static final String VK_KEY_ID = "id";
    public static final String VK_KEY_PROFILES = "profiles";
    public static final String VK_KEY_GROUPS = "groups";
    public static final String VK_KEY_ITEMS = "items";
    public static final String VK_KEY_PHOTO_604 = "photo_604";
    public static final String VK_KEY_TEXT = "text";
    public static final String VK_KEY_ATTACHMENTS = "attachments";
    public static final String VK_KEY_TYPE = "type";
    public static final String VK_KEY_COPY_HISTORY = "copy_history";
    public static final String VK_TYPE_PHOTO = "photo";
    public static final String VK_API_NEWSFEED_GET = "newsfeed.get";
    public static final String VK_CONST_FILTERS = "post";
    public static final String VK_CONST_COUNT = "100";
    public static final String VK_API_CONST_START_TIME = "start_time";

    // FEEDITEM
    public static final SimpleDateFormat FEED_ITEM_HEAD_TIME_PATTERN = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
    static {
        FEED_ITEM_HEAD_TIME_PATTERN.setTimeZone(TimeZone.getDefault());
    }

    // FEEDLIST
    // public static final float ROW_LAYOUT_MAX_HEIGHT = resources.getDimensionPixelSize(R.dimen.row_layout_max_height);
    public static final float SWIPE_FULL_TRASHHOLD = 0.85f;
    public static final float SWIPE_LOCK_SIZE = resources.getDimensionPixelSize(R.dimen.swipe_lock_size);
    public static final float SWIPE_LOCK_TRASHHOLD = (SWIPE_FULL_TRASHHOLD * SCREEN_WIDTH_PX - SWIPE_LOCK_SIZE) / SCREEN_WIDTH_PX;
    public static final float SWIPE_LOCK_MARGIN = resources.getDimensionPixelSize(R.dimen.swipe_lock_margin);
    public static final Paint SWIPE_LEFT_BACKGROUND_PAINT = new Paint();
    static {
        SWIPE_LEFT_BACKGROUND_PAINT.setColor(getResolvedColor(R.color.swipe_left_background));
    }
    public static final Paint SWIPE_RIGHT_BACKGROUND_PAINT = new Paint();
    static {
        SWIPE_RIGHT_BACKGROUND_PAINT.setColor(getResolvedColor(R.color.swipe_right_background));
    }
    private static final float SWIPE_TEXT_SIZE = resources.getDimensionPixelSize(R.dimen.swipe_text_size);
    public static final float SWIPE_ICON_SIZE = resources.getDimensionPixelSize(R.dimen.swipe_icon_size);
    public static final float SWIPE_ICON_TEXT_BLANK_SIZE = resources.getDimensionPixelSize(R.dimen.swipe_icon_text_blank_size);
    public static final String SWIPE_LEFT_TEXT = resources.getString(R.string.swipe_left_text);
    public static final Drawable SWIPE_LEFT_ICON = resources.getDrawable(R.drawable.ic_forward_white_48dp, context.getTheme());
    public static final Rect SWIPE_LEFT_RECT = new Rect();
    public static final Paint SWIPE_LEFT_TEXT_PAINT = new Paint();
    static {
        SWIPE_LEFT_TEXT_PAINT.setTypeface(Typeface.create(SWIPE_LEFT_TEXT_PAINT.getTypeface(), Typeface.BOLD));
        SWIPE_LEFT_TEXT_PAINT.setColor(getResolvedColor(R.color.swipe_text_color));
        SWIPE_LEFT_TEXT_PAINT.setTextSize(SWIPE_TEXT_SIZE);
        SWIPE_LEFT_TEXT_PAINT.setTextAlign(Paint.Align.LEFT);
        SWIPE_LEFT_TEXT_PAINT.getTextBounds(SWIPE_LEFT_TEXT, 0, SWIPE_LEFT_TEXT.length(), SWIPE_LEFT_RECT);
    }
    public static final String SWIPE_RIGHT_TEXT = resources.getString(R.string.swipe_right_text);
    public static final Drawable SWIPE_RIGHT_ICON = resources.getDrawable(R.drawable.ic_delete_sweep_white_48dp, context.getTheme());
    public static final Paint SWIPE_RIGHT_TEXT_PAINT = new Paint();
    public static final Rect SWIPE_RIGHT_RECT = new Rect();
    static {
        SWIPE_RIGHT_TEXT_PAINT.setTypeface(Typeface.create(SWIPE_RIGHT_TEXT_PAINT.getTypeface(), Typeface.BOLD));
        SWIPE_RIGHT_TEXT_PAINT.setColor(getResolvedColor(R.color.swipe_text_color));
        SWIPE_RIGHT_TEXT_PAINT.setTextSize(SWIPE_TEXT_SIZE);
        SWIPE_RIGHT_TEXT_PAINT.setTextAlign(Paint.Align.LEFT);
        SWIPE_RIGHT_TEXT_PAINT.getTextBounds(SWIPE_RIGHT_TEXT, 0, SWIPE_RIGHT_TEXT.length(), SWIPE_RIGHT_RECT);
    }

    // LAYOUT
    public static final int LAYOUT_REPOST = R.layout.repost_layout;
    public static final int LAYOUT_SETTINGS = R.layout.settings_layout;
    public static final int LAYOUT_SINGLE_FEED_ITEM = R.layout.single_feed_item_layout;
    public static final int LAYOUT_FEED_LIST = R.layout.feed_list_layout;
    public static final int LAYOUT_FEED_LIST_ROW = R.layout.feed_list_row_layout;
    public static final int LAYOUT_LOGIN = R.layout.login_layout;
    public static final int LAYOUT_DRAWER_HEADER = R.layout.drawer_header;

    // VIEW
    public static final int VIEW_REPOST_ICON = R.drawable.ic_repeat_black_48dp;
    public static final int VIEW_TWITTER_LOGO = R.drawable.twitter_logo;
    public static final int VIEW_TWITTER_TEXT_BLOCK_LINK_COLOR = getResolvedColor(R.color.view_twitter_text_block_link_color);
    public static final int VIEW_VK_LOGO = R.drawable.vk_logo;
    public static final int VIEW_VK_TEXT_BLOCK_LINK_COLOR = getResolvedColor(R.color.view_vk_text_block_link_color);
    public static int VIEW_AUTHOR_INFO_TWITTER_TEXT_SIZE = resources.getDimensionPixelSize(R.dimen.view_author_info_twitter_text_size);
    public static final int VIEW_TEXT_BLOCK_TEXT_SIZE = resources.getDimensionPixelSize(R.dimen.view_text_block_text_size);
    public static final int VIEW_REPOST_ICON_SIZE = resources.getDimensionPixelSize(R.dimen.view_repost_icon_size);
    public static final int VIEW_REPOST_COLOR = getResolvedColor(R.color.repost_color);

    // DRAWER
    public static final int DRAWER_TEXT_COLOR = getResolvedColor(R.color.drawer_text_color);
    public static final int DRAWER_BACKGROUND_COLOR = getResolvedColor(R.color.drawer_background_color);
    public static final int DRAWER_TWITTER_COLOR = getResolvedColor(R.color.drawer_twitter_color);
    public static final int DRAWER_VK_COLOR = getResolvedColor(R.color.drawer_vk_color);
    public static final String DRAWER_NEW_ITEMS_POSTFIX = resources.getString(R.string.drawer_news_items_postfix);
}
