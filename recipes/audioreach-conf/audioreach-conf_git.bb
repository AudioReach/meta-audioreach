DESCRIPTION = "AudioReach configurations"
HOMEPAGE = "https://github.com/Audioreach/audioreach-conf"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCREV = "2c4b1b35f3ddbc94f682ee38cdbcede700aa8871"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/Audioreach/audioreach-conf.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
