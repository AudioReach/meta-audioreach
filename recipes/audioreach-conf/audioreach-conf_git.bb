DESCRIPTION = "AudioReach configurations"
HOMEPAGE = "https://github.com/Audioreach/audioreach-conf"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=849c526521c1203a789a87389d328892"

SRCREV = "e4de9ba743a43fb4430db083ce98fb8ccd37d2c6"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/Audioreach/audioreach-conf.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
