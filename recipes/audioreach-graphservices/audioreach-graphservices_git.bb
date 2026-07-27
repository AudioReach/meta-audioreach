SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef516c5438f1b599326a5e207572f477"

SRCREV = "8445aee939cb8b37d80eccf6b43baf778fef23c4"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

DEPENDS = "glib-2.0"
DEPENDS:append:qcom = " libdiag"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils"
EXTRA_OECONF:append:qcom = " --with-qcom --without-ats_transport_tcp_ip \
                             --without-ats_data_logging --with-msm-audio-ion-disable \
                             --without-dummy_diag --with-libdiag_headers \
"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

# audioreach-kernel-headers provides UAPI headers (linux/msm_audio.h) needed by
# osal shmem DMA based implementation.
PACKAGECONFIG[audio_dma_support] = "--with-audio_dma_support, --without-audio_dma_support, audioreach-kernel-headers"

PACKAGECONFIG:append:qcom = " audio_dma_support"
PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
RDEPENDS:${PN}:append:qcom = " diag-router"
