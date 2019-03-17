/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hg.danmoxiang_rrmvp.app;

import android.app.Application;
import android.content.Context;

import com.hg.danmoxiang_rrmvp.BuildConfig;
import com.hg.danmoxiang_rrmvp.integration.AppManager;
import com.tencent.bugly.Bugly;

import timber.log.Timber;


public class BaseApplication extends Application {



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {

        }
        Bugly.init(getApplicationContext(), "7b8819722a", false);

        AppManager.getAppManager().init(this);

    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();

    }

}
