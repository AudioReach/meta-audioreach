SUMMARY = "AudioReach Graph Manager"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCREV = "ee5a7d24654289caa68532342f6439eea689f14c"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphmgr.git;protocol=https;branch=master"
SRC_URI     += "file://agm_server.service"
SRC_URI     += "file://agm-dbus.conf"

DEPENDS = "glib-2.0 tinyalsa audioreach-graphservices audioreach-conf"

# Add dbus to DEPENDS only if --with-no-ipc is NOT in EXTRA_OECONF
DEPENDS:append = "${@bb.utils.contains('EXTRA_OECONF', '--with-no-ipc', '', ' dbus', d)}"

EXTRA_OECONF += "--with-glib --with-syslog"
EXTRA_OECONF:append:qcom = " --with-no-ipc"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_install:append () {
    if ${@bb.utils.contains('EXTRA_OECONF', '--with-no-ipc', 'false', 'true', d)}; then
    install -m 0644 ${UNPACKDIR}/agm_server.service -D ${D}${sysconfdir}/systemd/system/agm_server.service
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln -sf /etc/systemd/system/agm_server.service \
                      ${D}/etc/systemd/system/multi-user.target.wants/agm_server.service
    install -m 0644 ${UNPACKDIR}/agm-dbus.conf -D ${D}${sysconfdir}/dbus-1/system.d/agm-dbus.conf
    fi
}
SYSTEMD_SERVICE:${PN} = "${@bb.utils.contains('EXTRA_OECONF', '--with-no-ipc', '', 'agm_server.service', d)}"
RM_WORK_EXCLUDE += "${PN}"

PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps, audioreach-engine"
PACKAGECONFIG[use_default_acdb_path] = "--with-use-default-acdb-path, --without-use-default-acdb-path"

inherit autotools pkgconfig
