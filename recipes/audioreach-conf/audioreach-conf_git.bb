DESCRIPTION = "AudioReach configurations"
HOMEPAGE = "https://github.com/Audioreach/audioreach-conf"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=849c526521c1203a789a87389d328892"

SRCREV = "d2610c45160d2ca7ff7fb62d78be52971d2dc7f7"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/Audioreach/audioreach-conf.git;protocol=https;branch=master"

EXTRA_OECONF:append:qcom = " --with-qcom"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} += "${datadir}/alsa/ucm2/conf.virt.d/*"
