SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef516c5438f1b599326a5e207572f477"

SRCREV = "9e83632e4e8a6f775fda8be14358d54d422b5cb0"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

DEPENDS = "glib-2.0"
DEPENDS:append:qcom = " audioreach-kernel-headers libdiag"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils"
EXTRA_OECONF:append:qcom = " --with-qcom --with-audio_dma_support --without-ats_transport_tcp_ip \
                             --without-ats_data_logging --with-msm-audio-ion-disable \
                             --without-dummy_diag --with-libdiag_headers \
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
RDEPENDS:${PN}:append:qcom = "diag-router"
