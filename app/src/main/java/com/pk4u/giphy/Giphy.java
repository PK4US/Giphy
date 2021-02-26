package com.pk4u.giphy;

import android.app.Activity;
import android.content.Intent;

public class Giphy {

	public static final int REQUEST_GIPHY = 10012;
    public static final int PREVIEW_SMALL = 0;
    public static final int PREVIEW_MEDIUM = 1;
    public static final int PREVIEW_LARGE = 2;

    private Activity activity;
    private String apiKey;
    private String saveLocation;
    private int limit;
    private int previewSize;
    private long maxFileSize;
    private boolean useStickers;

    private Giphy(Activity activity, String apiKey) {
        this.activity = activity;
        this.apiKey = apiKey;
    }

    public void start(int requestCode) {
        Intent intent = new Intent(activity, GiphyActivity.class);
        intent.putExtra(GiphyActivity.EXTRA_API_KEY, apiKey);
        intent.putExtra(GiphyActivity.EXTRA_GIF_LIMIT, limit);
        intent.putExtra(GiphyActivity.EXTRA_PREVIEW_SIZE, previewSize);
        intent.putExtra(GiphyActivity.EXTRA_SIZE_LIMIT, maxFileSize);
        intent.putExtra(GiphyActivity.EXTRA_SAVE_LOCATION, saveLocation);
        intent.putExtra(GiphyActivity.EXTRA_USE_STICKERS, useStickers);
        activity.startActivityForResult(intent, requestCode);
    }

    public static class Builder {

        private Giphy giphy;

        public Builder(Activity activity, String apiKey) {
            this.giphy = new Giphy(activity, apiKey);
        }

        public Giphy.Builder setSaveLocation(String saveLocation) {
            giphy.saveLocation = saveLocation;
            return this;
        }

        public Giphy.Builder maxFileSize(long maxFileSize) {
            giphy.maxFileSize = maxFileSize;
            return this;
        }

        public Giphy.Builder setQueryLimit(int limit) {
            giphy.limit = limit;
            return this;
        }

        public Giphy.Builder setPreviewSize(int previewSize) {
            giphy.previewSize = previewSize;
            return this;
        }

        public Giphy.Builder useStickers(boolean useStickers) {
            giphy.useStickers = useStickers;
            return this;
        }

        public Giphy build() {
            return giphy;
        }

        public void start() {
            build().start(REQUEST_GIPHY);
        }
    }

}