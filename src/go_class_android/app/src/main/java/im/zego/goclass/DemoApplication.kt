package im.zego.goclass

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport
import im.zego.goclass.sdk.ZegoSDKManager
import im.zego.goclass.tool.CrashHandler
import im.zego.goclass.tool.Logger
import im.zego.goclass.tool.SharedPreferencesUtil
import im.zego.goclass.tool.ToastUtils

class DemoApplication : Application() {
    private val TAG = "DemoApplication"

    companion object {
        /**
         * 开发自测和调试版本，包含详细的日志等
         * @return Boolean
         */
        @JvmStatic
        fun isAlpha(): Boolean {
            return BuildConfig.appBuildType == "alpha"
        }

        /**
         * 打包给测试的版本，去掉部分显示和功能
         * @return Boolean
         */
        @JvmStatic
        fun isPreview(): Boolean {
            return BuildConfig.appBuildType == "preview"
        }

        /**
         * 准备上线的版本
         * @return Boolean
         */
        @JvmStatic
        fun isFinal(): Boolean {
            return BuildConfig.appBuildType == "final"
        }
    }

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(applicationContext)
        SharedPreferencesUtil.setApplicationContext(this)
        SharedPreferencesUtil.setProcessID(android.os.Process.myPid())
        if (!isAlpha()) {
            CrashHandler.setAppContext(this)
        }
        AppLanguage.initLanguageSetting(this)
        ToastUtils.setAppContext(this)
        ZegoSDKManager.getInstance().initSDKEnvironment(this) {
            Logger.i(TAG, "initResult() result: $it")
        }
    }


}