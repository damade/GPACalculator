package com.ou.gpa_calculator.Util.Views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.ou.gpa_calculator.R;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomTextView(Context context) {
        super(context);
        setTextColor(Color.WHITE);
        setTextColor(context.getColor(R.color.white));
        setTextAppearance(context, android.R.style.TextAppearance_DeviceDefault_Large);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf"));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTextColor(Color.WHITE);
        setTextColor(context.getColor(R.color.white));
        setTextAppearance(context, android.R.style.TextAppearance_DeviceDefault_Large);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf"));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextColor(Color.WHITE);
        setTextColor(context.getColor(R.color.white));
        setTextAppearance(context, android.R.style.TextAppearance_DeviceDefault_Large);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf"));
    }

}