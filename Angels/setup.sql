CREATE database angels;
use angels;
CREATE TABLE IF NOT EXISTS `searchresponse` (
  `id` varchar(10) NOT NULL,
  `pic` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `name` varchar(1000) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

commit;