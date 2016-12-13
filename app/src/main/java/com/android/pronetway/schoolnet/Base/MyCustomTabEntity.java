package com.android.pronetway.schoolnet.Base;

import android.support.annotation.DrawableRes;

/**
 * Created by Coleman on 2016/12/6.
 */
public interface MyCustomTabEntity  {
    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();
}
