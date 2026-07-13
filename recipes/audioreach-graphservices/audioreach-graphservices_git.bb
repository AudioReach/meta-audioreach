SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef516c5438f1b599326a5e207572f477"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils --with-dummy_diag"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

# audioreach-kernel provides UAPI headers (linux/msm_audio.h) needed by
# osal shmem DMA based implementation.
PACKAGECONFIG[audio_dma_support] = "--with-audio_dma_support, --without-audio_dma_support, audioreach-kernel"

PACKAGECONFIG:append:qcom = " audio_dma_support"
PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
