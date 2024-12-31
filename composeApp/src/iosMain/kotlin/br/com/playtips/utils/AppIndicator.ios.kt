package br.com.playtips.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import androidx.compose.ui.viewinterop.UIKitViewController
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UIntVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import kotlinx.coroutines.Delay
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import platform.CoreImage.CIColor
import platform.Foundation.NSScanner
import platform.Foundation.scanHexInt
import platform.UIKit.UIActivityIndicatorView
import platform.UIKit.UIActivityIndicatorViewStyleGray
import platform.UIKit.UIActivityIndicatorViewStyleMedium
import platform.UIKit.UIApplication
import platform.UIKit.UIColor
import platform.UIKit.UILabel
import platform.UIKit.UIProgressView
import platform.UIKit.UIProgressViewStyle
import platform.UIKit.UIView
import platform.UIKit.UIViewNoIntrinsicMetric
import platform.UIKit.systemBackgroundColor
import platform.UIKit.underPageBackgroundColor
import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/*class IosAppIndicator : AppIndicator{
     private val progress: Float = 0.0f
     private val style: String = ""


   fun getIndicator(progress: Float, style: String, colorString: String): UIProgressView {
        val progressView =
            UIProgressView(progressViewStyle = UIProgressViewStyle.UIProgressViewStyleDefault)
        progressView.setProgress(progress, true)
        progressView.progressTintColor = UIColor.fromHexString("#0xff1a1a1a") // Customize the color here
        return progressView;
    }

    @OptIn(ExperimentalForeignApi::class)
    fun UIColor.Companion.fromHexString(hex: String): UIColor {
        val hexString = hex.trimStart('#')
        val scanner = NSScanner(string = hexString)
        var hexNumber: UIntVar = nativeHeap.alloc<UIntVar>()
        if (scanner.scanHexInt(hexNumber.ptr)) {
            val r = (hexNumber.value.toInt() and 0xff0000) shr 16
            val g = (hexNumber.value.toInt() and 0x00ff00) shr 8
            val b = hexNumber.value.toInt() and 0x0000ff
            return UIColor(
                red = r.toDouble() / 255.0,
                green = g.toDouble() / 255.0,
                blue = b.toDouble() / 255.0,
                alpha = 1.0
            )
        }
        return blackColor
    }

}
actual fun getIndicator():AppIndicator = IosAppIndicator()*/
@OptIn(ExperimentalForeignApi::class, InternalCoroutinesApi::class)
@Composable
actual fun AppIndicator(modifier: Modifier): Unit {
    var indicatorView = UIActivityIndicatorView()


  UIKitView(
        modifier = modifier,
        onReset = {},
        //onRelease = { indicatorView.stopAnimating()},

        factory = {

            /* var uiProgressView= UIProgressView(progressViewStyle = UIProgressViewStyle.UIProgressViewStyleDefault);
               uiProgressView.setProgress(0.5f)
               uiProgressView.setProgressTintColor(UIColor.fromHexString("#0xffeeeeee"))
               val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
              // rootViewController?.view?.addSubview(uiProgressView)
              // rootViewController?.view!!
              uiProgressView.viewForBaselineLayout()*/

        /*    var indicatorView: UIActivityIndicatorView = UIActivityIndicatorView()
            indicatorView.setColor(UIColor.blackColor)*/

            indicatorView.startAnimating()


            val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
            rootViewController?.view?.addSubview(indicatorView)
            rootViewController?.view?.setBackgroundColor(null)


            indicatorView.setColor(UIColor.whiteColor)
            indicatorView.layer.setOpaque(false)
            //indicatorView.layer.backgroundColor = UIColor.clearColor.CGColor
            indicatorView.backgroundColor = UIColor.clearColor

            indicatorView
                 /* UIActivityIndicatorView().apply {
                      color = UIColor.blueColor
                     // backgroundColor = UIColor.clearColor
                      layer.backgroundColor = UIColor.clearColor.CGColor
                      opaque = false
                      startAnimating()
                  }.viewForBaselineLayout()*/
        },

    )
}

@OptIn(ExperimentalForeignApi::class)
fun UIColor.Companion.fromHexString(hex: String): UIColor {
    val hexString = hex.trimStart('#')
    val scanner = NSScanner(string = hexString)
    var hexNumber: UIntVar = nativeHeap.alloc<UIntVar>()
    if (scanner.scanHexInt(hexNumber.ptr)) {
        val r = (hexNumber.value.toInt() and 0xff0000) shr 16
        val g = (hexNumber.value.toInt() and 0x00ff00) shr 8
        val b = hexNumber.value.toInt() and 0x0000ff
        return UIColor(
            red = r.toDouble() / 255.0,
            green = g.toDouble() / 255.0,
            blue = b.toDouble() / 255.0,
            alpha = 1.0
        )
    }
    return grayColor
}





