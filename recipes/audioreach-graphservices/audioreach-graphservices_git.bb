SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef516c5438f1b599326a5e207572f477"

SRCREV = "7a76df677606833ccb7521a1487ae1129a9c3f04"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

DEPENDS = "glib-2.0"
DEPENDS:append:qcom = " audioreach-kernel-headers"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils --with-dummy_diag"
EXTRA_OECONF:append:qcom = " --with-qcom --with-audio_dma_support --without-ats_transport_tcp_ip \
                             --without-ats_data_logging --with-msm-audio-ion-disable \
"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
