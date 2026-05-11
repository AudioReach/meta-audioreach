DESCRIPTION = "AudioReach configurations"
HOMEPAGE = "https://github.com/Audioreach/audioreach-conf"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=849c526521c1203a789a87389d328892"

SRCREV = "a8c8cf1481534ef5ab74fdedf9aeaa1e69cf17de"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/Audioreach/audioreach-conf.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} += "${datadir}/alsa/ucm2/conf.virt.d/*"
