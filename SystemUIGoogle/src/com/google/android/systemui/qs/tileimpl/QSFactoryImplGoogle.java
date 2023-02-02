/*
 * Copyright (C) 2022 The PixelExperience Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.systemui.qs.tileimpl;

import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.plugins.qs.QSTile;
import com.android.systemui.qs.QSHost;
import com.android.systemui.qs.external.CustomTile;
import com.android.systemui.qs.tileimpl.QSFactoryImpl;
import com.android.systemui.qs.tileimpl.QSTileImpl;
import com.android.systemui.qs.tiles.AirplaneModeTile;
import com.android.systemui.qs.tiles.AlarmTile;
import com.android.systemui.qs.tiles.AmbientDisplayTile;
import com.android.systemui.qs.tiles.AntiFlickerTile;
import com.android.systemui.qs.tiles.AODTile;
import com.android.systemui.qs.tiles.BatterySaverTile;
import com.android.systemui.qs.tiles.BluetoothTile;
import com.android.systemui.qs.tiles.CPUInfoTile;
import com.android.systemui.qs.tiles.CaffeineTile;
import com.android.systemui.qs.tiles.CameraToggleTile;
import com.android.systemui.qs.tiles.CastTile;
import com.android.systemui.qs.tiles.CellularTile;
import com.android.systemui.qs.tiles.ColorCorrectionTile;
import com.android.systemui.qs.tiles.ColorInversionTile;
import com.android.systemui.qs.tiles.CompassTile;
import com.android.systemui.qs.tiles.DataSaverTile;
import com.android.systemui.qs.tiles.DataSwitchTile;
import com.android.systemui.qs.tiles.DcDimmingTile;
import com.android.systemui.qs.tiles.DeviceControlsTile;
import com.android.systemui.qs.tiles.DndTile;
import com.android.systemui.qs.tiles.DreamTile;
import com.android.systemui.qs.tiles.FPSInfoTile;
import com.android.systemui.qs.tiles.FlashlightTile;
import com.android.systemui.qs.tiles.GloveModeTile;
import com.android.systemui.qs.tiles.HeadsUpTile;
import com.android.systemui.qs.tiles.HotspotTile;
import com.android.systemui.qs.tiles.InternetTile;
import com.android.systemui.qs.tiles.LiveDisplayTile;
import com.android.systemui.qs.tiles.LocaleTile;
import com.android.systemui.qs.tiles.LocationTile;
import com.android.systemui.qs.tiles.MicrophoneToggleTile;
import com.android.systemui.qs.tiles.NfcTile;
import com.android.systemui.qs.tiles.NightDisplayTile;
import com.android.systemui.qs.tiles.OnTheGoTile;
import com.android.systemui.qs.tiles.OneHandedModeTile;
import com.android.systemui.qs.tiles.PowerShareTile;
import com.android.systemui.qs.tiles.QRCodeScannerTile;
import com.android.systemui.qs.tiles.QuickAccessWalletTile;
import com.android.systemui.qs.tiles.ReadingModeTile;
import com.android.systemui.qs.tiles.RebootTile;
import com.android.systemui.qs.tiles.ReduceBrightColorsTile;
import com.android.systemui.qs.tiles.RefreshRateTile;
import com.android.systemui.qs.tiles.RotationLockTile;
import com.android.systemui.qs.tiles.ScreenRecordTile;
import com.android.systemui.qs.tiles.ScreenshotTile;
import com.android.systemui.qs.tiles.SleepModeTile;
import com.android.systemui.qs.tiles.SmartPixelsTile;
import com.android.systemui.qs.tiles.SoundSearchTile;
import com.android.systemui.qs.tiles.SoundTile;
import com.android.systemui.qs.tiles.SyncTile;
import com.android.systemui.qs.tiles.UiModeNightTile;
import com.android.systemui.qs.tiles.UsbTetherTile;
import com.android.systemui.qs.tiles.VolumeTile;
import com.android.systemui.qs.tiles.VPNTetheringTile;
import com.android.systemui.qs.tiles.VpnTile;
import com.android.systemui.qs.tiles.WifiTile;
import com.android.systemui.qs.tiles.WorkModeTile;
import com.android.systemui.util.leak.GarbageMonitor;
import com.google.android.systemui.qs.tiles.BatterySaverTileGoogle;
import com.google.android.systemui.qs.tiles.ReverseChargingTile;

// Custom
import com.android.systemui.qs.tiles.PowerShareTile;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;


@SysUISingleton
public class QSFactoryImplGoogle extends QSFactoryImpl {
    private final Provider<BatterySaverTileGoogle> mBatterySaverTileGoogleProvider;
    private final Provider<ReverseChargingTile> mReverseChargingTileProvider;

    @Inject
    public QSFactoryImplGoogle(
            Lazy<QSHost> qsHostLazy,
            Provider<CustomTile.Builder> customTileBuilderProvider,
            Provider<WifiTile> wifiTileProvider,
            Provider<InternetTile> internetTileProvider,
            Provider<BluetoothTile> bluetoothTileProvider,
            Provider<CellularTile> cellularTileProvider,
            Provider<DndTile> dndTileProvider,
            Provider<ColorInversionTile> colorInversionTileProvider,
            Provider<AirplaneModeTile> airplaneModeTileProvider,
            Provider<WorkModeTile> workModeTileProvider,
            Provider<RotationLockTile> rotationLockTileProvider,
            Provider<FlashlightTile> flashlightTileProvider,
            Provider<LocationTile> locationTileProvider,
            Provider<CastTile> castTileProvider,
            Provider<HotspotTile> hotspotTileProvider,
            Provider<BatterySaverTileGoogle> batterySaverTileGoogleProvider,
            Provider<DataSaverTile> dataSaverTileProvider,
            Provider<NightDisplayTile> nightDisplayTileProvider,
            Provider<NfcTile> nfcTileProvider,
            Provider<GarbageMonitor.MemoryTile> memoryTileProvider,
            Provider<UiModeNightTile> uiModeNightTileProvider,
            Provider<ScreenRecordTile> screenRecordTileProvider,
            Provider<ReduceBrightColorsTile> reduceBrightColorsTileProvider,
            Provider<CameraToggleTile> cameraToggleTileProvider,
            Provider<MicrophoneToggleTile> microphoneToggleTileProvider,
            Provider<DeviceControlsTile> deviceControlsTileProvider,
            Provider<AlarmTile> alarmTileProvider,
            Provider<QuickAccessWalletTile> quickAccessWalletTileProvider,
            Provider<QRCodeScannerTile> qrCodeScannerTileProvider,
            Provider<OneHandedModeTile> oneHandedModeTileProvider,
            Provider<ColorCorrectionTile> colorCorrectionTileProvider,
            Provider<DreamTile> dreamTileProvider,
            Provider<ReverseChargingTile> reverseChargingTileProvider,
            Provider<PowerShareTile> powerShareTileProvider,
            Provider<CaffeineTile> caffeineTileProvider,
            Provider<AmbientDisplayTile> ambientDisplayTileProvider,
            Provider<UsbTetherTile> usbTetherTileProvider,
            Provider<SyncTile> syncTileProvider,
            Provider<SoundTile> soundTileProvider,
            Provider<HeadsUpTile> headsUpTileProvider,
            Provider<RebootTile> rebootTileProvider,
            Provider<VolumeTile> volumeTileProvider,
            Provider<SoundSearchTile> soundSearchTileProvider,
            Provider<VpnTile> vpnTileProvider,
            Provider<LiveDisplayTile> liveDisplayTileProvider,
            Provider<ReadingModeTile> readingModeTileProvider,
            Provider<AntiFlickerTile> antiFlickerTileProvider,
            Provider<DataSwitchTile> dataSwitchTileProvider,
            Provider<AODTile> aodTileProvider,
            Provider<RefreshRateTile> refreshRateTileProvider,
            Provider<FPSInfoTile> fpsInfoTileProvider,
            Provider<OnTheGoTile> onTheGoTileProvider,
            Provider<CPUInfoTile> cpuInfoTileProvider,
            Provider<ScreenshotTile> screenshotTileProvider,
            Provider<VPNTetheringTile> vpnTetheringTileProvider,
            Provider<GloveModeTile> gloveModeTileProvider,
            Provider<CompassTile> compassTileProvider,
            Provider<SleepModeTile> sleepModeTileProvider,
            Provider<DcDimmingTile> dcDimTileProvider,
            Provider<LocaleTile> localeTileProvider,
            Provider<SmartPixelsTile> smartPixelsTileProvider) {
        super(qsHostLazy,
                customTileBuilderProvider,
                wifiTileProvider,
                internetTileProvider,
                bluetoothTileProvider,
                cellularTileProvider,
                dndTileProvider,
                colorInversionTileProvider,
                airplaneModeTileProvider,
                workModeTileProvider,
                rotationLockTileProvider,
                flashlightTileProvider,
                locationTileProvider,
                castTileProvider,
                hotspotTileProvider,
                () -> batterySaverTileGoogleProvider.get(),
                dataSaverTileProvider,
                nightDisplayTileProvider,
                nfcTileProvider,
                memoryTileProvider,
                uiModeNightTileProvider,
                screenRecordTileProvider,
                reduceBrightColorsTileProvider,
                cameraToggleTileProvider,
                microphoneToggleTileProvider,
                deviceControlsTileProvider,
                alarmTileProvider,
                quickAccessWalletTileProvider,
                qrCodeScannerTileProvider,
                oneHandedModeTileProvider,
                colorCorrectionTileProvider,
                dreamTileProvider,
                powerShareTileProvider,
                caffeineTileProvider,
                ambientDisplayTileProvider,
                usbTetherTileProvider,
                syncTileProvider,
                soundTileProvider,
                headsUpTileProvider,
                rebootTileProvider,
                volumeTileProvider,
                soundSearchTileProvider,
                vpnTileProvider,
                liveDisplayTileProvider,
                readingModeTileProvider,
                antiFlickerTileProvider,
                dataSwitchTileProvider,
                aodTileProvider,
                refreshRateTileProvider,
                fpsInfoTileProvider,
                onTheGoTileProvider,
                cpuInfoTileProvider,
                screenshotTileProvider,
                vpnTetheringTileProvider,
                gloveModeTileProvider,
                compassTileProvider,
                sleepModeTileProvider,
                dcDimTileProvider,
                localeTileProvider,
                smartPixelsTileProvider);
        mReverseChargingTileProvider = reverseChargingTileProvider;
        mBatterySaverTileGoogleProvider = batterySaverTileGoogleProvider;
    }

    @Override
    public final QSTileImpl createTileInternal(String str) {
        if (str.equals("reverse")) {
            return mReverseChargingTileProvider.get();
        } else if (str.equals("battery")) {
            return mBatterySaverTileGoogleProvider.get();
        }
        return super.createTileInternal(str);
    }
}
