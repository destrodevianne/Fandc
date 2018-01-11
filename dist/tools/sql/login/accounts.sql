CREATE TABLE IF NOT EXISTS `accounts` (
  `login` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `secondaryPassword` varchar(32) DEFAULT NULL,
  `access_level` int(11) NOT NULL DEFAULT '0',
  `ban_expire` int(11) NOT NULL DEFAULT '0',
  `allow_ip` varchar(255) DEFAULT NULL,
  `allow_hwid` varchar(255) DEFAULT NULL,
  `bonus` double NOT NULL DEFAULT '1',
  `bonus_expire` int(11) NOT NULL DEFAULT '0',
  `last_server` int(11) NOT NULL DEFAULT '0',
  `last_ip` varchar(15) DEFAULT NULL,
  `last_access` int(11) NOT NULL DEFAULT '0',
  `bot_report_points` int(10) NOT NULL DEFAULT '7',
  `points` int(11) NOT NULL default '0',
  PRIMARY KEY (`login`),
  KEY `last_ip` (`last_ip`)
) DEFAULT CHARSET=utf8;