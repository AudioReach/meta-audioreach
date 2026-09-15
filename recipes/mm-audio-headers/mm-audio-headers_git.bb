DESCRIPTION = "AudioReach mm-audio-headers"
HOMEPAGE = "https://github.com/AudioReach/mm-audio-headers"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=849c526521c1203a789a87389d328892"

SRCREV = "c5b725f03841eca2735af1f3534e1542573f1411"
PV = "0.0+git"

SRC_URI = "git://github.com/AudioReach/mm-audio-headers.git;protocol=https;branch=main"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} += "${includedir} ${libdir}/pkgconfig"
