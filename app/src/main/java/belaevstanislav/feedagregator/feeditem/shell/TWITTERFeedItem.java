package belaevstanislav.feedagregator.feeditem.shell;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.UrlEntity;

import java.text.ParseException;

import belaevstanislav.feedagregator.feeditem.core.FeedItemCore;
import belaevstanislav.feedagregator.util.Constant;
import belaevstanislav.feedagregator.util.view.TextBlock;
import belaevstanislav.feedagregator.util.view.ViewMethod;

public class TWITTERFeedItem extends FeedItem {
    private final String authorInfo;
    private final String text;
    private final String imageUrl;

    public TWITTERFeedItem(FeedItemCore core, long id, Tweet tweet) throws ParseException {
        super(core, id, tweet.user.name, tweet.user.profileImageUrl);

        this.authorInfo = "@" + tweet.user.screenName;

        TweetEntities entities = tweet.entities;
        String preText = tweet.text;
        if (entities.urls != null) {
            int size = entities.urls.size();
            for (int index = 0; index < size; index++) {
                UrlEntity entity = entities.urls.get(index);
                preText = preText.replaceAll(entity.url, entity.displayUrl);
            }
        }
        /*List<HashtagEntity> hashtags = entities.hashtags;
        if (hashtags != null) {
            int size = hashtags.size();
            for (int index = 0; index < size; index++) {
                HashtagEntity entity = hashtags.get(index);
            }
        }*/
        this.text = preText;

        String preImageUrl = null;
        if (entities.media != null) {
            preImageUrl = entities.media.get(0).mediaUrl;
        }
        /*if (tweet.extendedEtities != null && tweet.extendedEtities.media.get(0).type.equals("photo")) {
            preImageUrl = tweet.extendedEtities.media.get(0).mediaUrl;
        }*/
        this.imageUrl = preImageUrl;
    }

    @Override
    public int getLogo() {
        return Constant.VIEW_TWITTER_LOGO;
    }

    @Override
    void drawSpecialHead(Context context, LinearLayout info) {
        TextView twitterAddress = new TextView(context);
        twitterAddress.setTextSize(Constant.VIEW_AUTHOR_INFO_TWITTER_TEXT_SIZE);
        twitterAddress.setText(authorInfo);
        info.addView(twitterAddress);
    }



    @Override
    void fillContent(Context context, LinearLayout content) {
        if (!text.equals("")) {
            TextBlock textBlock = new TextBlock(context);
            textBlock.setText(text);
            ViewMethod.linkify(textBlock, Constant.VIEW_TWITTER_TEXT_BLOCK_LINK_COLOR);
            content.addView(textBlock);
        }

        if (imageUrl != null) {
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load(imageUrl).tag(context).into(imageView);
            content.addView(imageView);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(authorInfo);
        dest.writeString(text);
        dest.writeString(imageUrl);
    }

    public static final Parcelable.Creator<TWITTERFeedItem> CREATOR =
            new Parcelable.Creator<TWITTERFeedItem>() {
                @Override
                public TWITTERFeedItem createFromParcel(Parcel in) {
                    return new TWITTERFeedItem(in);
                }

                @Override
                public TWITTERFeedItem[] newArray(int size) {
                    return new TWITTERFeedItem[size];
                }
            };

    private TWITTERFeedItem(Parcel in) {
        super(in);
        authorInfo = in.readString();
        text = in.readString();
        imageUrl = in.readString();
    }
}

