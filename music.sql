# Host: localhost  (Version: 5.5.5-10.1.13-MariaDB)
# Date: 2016-11-24 10:44:40
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "collection"
#

CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `mid` int(11) DEFAULT NULL COMMENT '音乐ID',
  `time` datetime DEFAULT NULL,
  `type` int(2) DEFAULT '0' COMMENT '0-最近播放 1-收藏 2 -我的最爱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='收藏表';

#
# Data for table "collection"
#

INSERT INTO `collection` VALUES (4,3,438801442,'2016-11-18 23:51:26',1),(5,3,34383213,'2016-11-18 23:51:45',1),(6,1,438801442,'2016-11-19 10:55:40',1),(7,1,34962116,'2016-11-19 10:56:52',1),(10,1,407927752,'2016-11-19 14:47:55',0),(11,1,407927752,'2016-11-19 14:48:23',0),(12,1,407927752,'2016-11-19 14:48:33',0),(14,2,438801442,'2016-11-19 15:07:06',1),(17,1,406000141,'2016-11-20 16:45:42',0),(18,1,2526613,'2016-11-20 16:46:02',0),(19,1,41640043,'2016-11-20 16:46:45',0),(20,1,34962116,'2016-11-20 16:48:29',0),(23,1,16426514,'2016-11-20 16:53:24',1),(41,5,438801442,'2016-11-20 22:01:39',1),(45,5,438801442,'2016-11-20 22:02:17',0),(46,5,34383213,'2016-11-20 22:02:29',0),(47,5,407927752,'2016-11-20 22:02:57',0),(49,6,407927752,'2016-11-20 22:22:52',1),(51,6,407927752,'2016-11-20 22:23:09',0),(53,6,32063592,'2016-11-20 22:25:16',1),(54,6,32063592,'2016-11-20 22:25:17',0),(56,6,16426514,'2016-11-20 22:26:22',0),(57,3,438801442,'2016-11-21 10:53:48',0),(85,1,16426514,'2016-11-21 11:34:07',0),(91,3,34383213,'2016-11-21 13:44:32',0),(109,3,16426514,'2016-11-21 17:12:23',1),(110,3,16426514,'2016-11-21 17:12:24',0),(111,1,422252384,'2016-11-22 18:03:09',0),(112,1,438801442,'2016-11-22 18:03:18',0),(114,8,35847559,'2016-11-24 09:30:12',1),(118,3,35847559,'2016-11-24 09:49:01',0),(120,3,36586466,'2016-11-24 10:04:51',0),(121,8,35847559,'2016-11-24 10:33:12',0);

#
# Source for table "comment"
#

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '音乐id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `fid` int(11) DEFAULT NULL COMMENT '父评论ID',
  `fuid` varchar(255) DEFAULT NULL COMMENT '父评论用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  `likeNum` int(11) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='评论表';

#
# Data for table "comment"
#

INSERT INTO `comment` VALUES (3,438801442,1,0,'0','这首歌是谁唱的','0000-00-00 00:00:00',0),(4,438801442,3,NULL,NULL,'这首歌不错','2016-11-18 22:00:30',0),(5,438801442,3,NULL,NULL,'我要循环','2016-11-18 22:01:48',0),(6,438801442,3,NULL,NULL,'大家好好的听这首歌吧','2016-11-18 22:03:51',0),(7,34383213,3,NULL,NULL,'戳爷的歌','2016-11-18 23:38:21',1),(8,407927752,1,NULL,NULL,'Troye Sivan','2016-11-19 14:48:22',1),(9,438801442,2,NULL,NULL,'很带感 ','2016-11-19 15:05:47',1),(10,418550450,2,NULL,NULL,'这首歌真的很不错','2016-11-19 15:13:46',0),(11,4153654,2,NULL,NULL,'林肯公园的歌','2016-11-19 15:21:30',0),(12,1336532,2,NULL,NULL,'经典英文歌曲','2016-11-19 15:24:22',0),(13,16426514,1,NULL,NULL,'这首歌是电影《命中注定》的插曲','2016-11-20 16:57:18',1),(16,407927752,6,NULL,NULL,'1111','2016-11-20 22:23:08',0),(17,36586466,3,NULL,NULL,'Justin bieber最新单曲','2016-11-24 10:04:49',0);

#
# Source for table "download"
#

CREATE TABLE `download` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户Id',
  `mid` int(11) DEFAULT NULL COMMENT '音乐id',
  `time` datetime DEFAULT NULL COMMENT '下载时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='下载表';

#
# Data for table "download"
#

INSERT INTO `download` VALUES (1,1,1,'0000-00-00 00:00:00');

#
# Source for table "music"
#

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `musicName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `singer` varchar(255) DEFAULT NULL COMMENT '歌手名',
  `albumName` varchar(255) DEFAULT NULL COMMENT '专辑名称',
  `songId` varchar(255) DEFAULT NULL COMMENT '存放地址',
  `playNum` int(11) DEFAULT NULL COMMENT '播放次数',
  `picUrl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='音乐表';

#
# Data for table "music"
#

INSERT INTO `music` VALUES (3,'One Call Away','Charlie Puth','Nine Track Mind Deluxe','440317243',1,'http://p4.music.126.net/3cRKFs_7Ajr2z5clqYyLkQ==/2946691242777144.jpg'),(5,'FOOLS','Troye Sivan','WILD','34383213',11,'http://p4.music.126.net/FMtH01nLonFEU9xt0kBRpQ==/7891194953801107.jpg'),(6,'Miracle In The Middle Of My Heart (Original Mix)','Clément Bcx','Miracle In The Middle Of My Heart (Original Mix)','36492196',1,'http://p4.music.126.net/e9qczVaDmqG832IaC5NqLQ==/3407386536611778.jpg'),(8,'Tomorrow','Olly Murs','Never Been Better','29709522',1,'http://p3.music.126.net/jja_h4yBREM3S7kDuaE7JA==/3229265651727818.jpg'),(9,'I Don\'t Mind If You Don\'t Mind','Ron Pope','The New England Sessions','27472194',1,'http://p4.music.126.net/vYzap0zTciUL7WmJWLtYuA==/2848834627613620.jpg'),(10,'バトル＃58','Falcom Sound Team jdk','イース セルセタの樹海 オリジナルサウンドトラック','34962116',2,'http://p4.music.126.net/GxrjlSyRAV9wARR56M0qww==/6033020302131714.jpg'),(11,'JULY','吴亦凡','JULY','438801442',37,'http://p3.music.126.net/EbtEQchXFKPOc1dQbxM6ig==/18550960184779345.jpg'),(12,'Skyfall - The Voice Australia 2016 Performance','Elle Murphy','Skyfall','422252384',2,'http://p4.music.126.net/nxf5igG9tSw2p5UdZkIe7w==/18285977881947927.jpg'),(13,'YOUTH - Gryffin Remix','Troye Sivan','YOUTH (Gryffin Remix)','407927752',8,'http://p4.music.126.net/mtEBZNwlYpe8IAtThhWyNQ==/18178225742519611.jpg'),(14,'WILD','Troye Sivan','WILD','418550450',3,'http://p3.music.126.net/Pv3SW0NrXFo1yRJsbg679w==/1395280268015147.jpg'),(15,'Papercut','Linkin Park','Papercut','4153654',2,'http://p3.music.126.net/-lUD5J3607Sb8Ecjgvwl6Q==/884007348777471.jpg'),(16,'Five Hundred Miles','Eric Bibb','Livin\', Lovin\' and Doin\'','1336532',2,'http://p3.music.126.net/pkMCP6avkbTvFmojA6iHWg==/863116627855093.jpg'),(17,'Fools','GLADES','Fools','417859618',1,'http://p4.music.126.net/Wv47DEXbKFuwSfd7lHvfWA==/1413971965416187.jpg'),(18,'Gentelman','MattyB','MattyB翻唱合集','406000141',1,'http://p4.music.126.net/_SqYlW-Rp3wKTHmHd9B__A==/16675193347434444.jpg'),(19,'Booty Music','Deep Side','Booty Music','2526613',1,'http://p4.music.126.net/5SNTMoXZtszPWHxwU2ZOHg==/829031767396128.jpg'),(20,'Fuck','徐梦圆','Fuck','41640043',1,'http://p4.music.126.net/q7Y23XZu6WRmj94qO-Lwdw==/16592729975160601.jpg'),(21,'Almost Lover','A Fine Frenzy','One Cell In The Sea','16426514',59,'http://p4.music.126.net/bP0WpuFWBB3-o2MB4siigQ==/668503069695120.jpg'),(22,'happybirthday','将西','将西的Demo','29829757',1,'http://p4.music.126.net/Ae0bQ-Yni_10wP4dB3E3Ng==/3246857839429556.jpg'),(23,'Baby','Justin Bieber','Baby','18638057',1,'http://p3.music.126.net/S3Mkc-lfXPgsuUYxqVd4yQ==/710284511552973.jpg'),(24,'Paladin','EnV','Paladin','32063592',2,'http://p4.music.126.net/5fsiRGTHt8gSA3JFkj6pDw==/2919203373226731.jpg'),(25,'Sorry','Justin Bieber','Sorry','35847559',6,'http://p3.music.126.net/wB6uI7lqujPT10C9V-NI_Q==/3296335861579899.jpg'),(26,'Purpose','Justin Bieber','Purpose','36586466',2,'http://p4.music.126.net/SmaGv_bQTYy5_uOmnAz4Mw==/3285340746015046.jpg');

#
# Source for table "user"
#

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(30) DEFAULT NULL COMMENT '性别',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `headimg` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `status` int(11) DEFAULT '0' COMMENT '0-正常 1-被禁用 2- 管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'zhaowenyi','zhaowenyi','','男',20,'/assets/uploadsheadImg/1/1479461181288.jpg',0),(2,'赵文奕','赵文奕','','',13,'/assets/uploadsheadImg/2/1479539015466.jpg',0),(3,'renaissance','renaissance','','男',20,'/assets/uploadsheadImg/3/1479477556873.jpg',0),(4,'wenyi','wenyi','','',0,'/assets/uploadsheadImg/4/1479541057917.jpg',2),(5,'tm','tm','','男',0,'/assets/uploadsheadImg/5/1479650299633.jpg',1),(6,'frown','123','','',0,'/assets/uploadsheadImg/6/1479651825350.jpg',0),(8,'高艺珩','123','','男',21,'/assets/uploadsheadImg/8/1479950914289.jpg',0);
