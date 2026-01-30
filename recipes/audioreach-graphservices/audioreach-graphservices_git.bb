SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6921cdd00790cae6b02ce61e60ab9e55"

SRCREV = "f5ff09d4b28a5b90389058d0803a2ad3e3690730"
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
