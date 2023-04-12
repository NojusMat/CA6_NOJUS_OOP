CREATE TABLE Player ( id int NOT NULL AUTO_INCREMENT,
    first_Name VARCHAR(50) NOT NULL,
    last_Name VARCHAR(50) NOT NULL,
    team VARCHAR(50) NOT NULL,
    height_in_Cm DECIMAL(13, 2) NOT NULL,
	 weight_in_Kg INT NOT NULL,
    points_Per_Game FLOAT  NOT NULL,
    PRIMARY KEY(id),
   	FOREIGN KEY(team) REFERENCES Teams(team)
);

INSERT INTO Player VALUES
(1, 'LeBron', 'James', 'Los Angeles Lakers', 209.12, 115, 25.0),
(2, 'Anthony', 'Davis', 'Los Angeles Lakers', 220.75, 110, 23.3),
(3, 'Stephen', 'Curry', 'Golden State Warriors', 190.43, 85, 25.5),
(4, 'Trae', 'Young', 'Atlanta Hawks', 185.98,80, 23.5),
(5, 'Jimmy', 'Butler', 'Miami Heat', 200.76, 110, 22.2),
(6, 'Luka', 'Doncic', 'Dallas Mavericks', 200.36, 99, 26.6),
(7, 'Kawhi', 'Leonard', 'Los Angeles Clippers', 201.28, 100, 25.0),
(8, 'Joel', 'Embiid', 'Philadelphia 76ers', 215.50,115, 27.3),
(9, 'Damian', 'Lillard', 'Portland Trail Blazers', 180.12, 85, 21.1),
(10, 'Nikola', 'Jokic', 'Denver Nuggets', 214.09,130, 26.4),
(11, 'Kyrie', 'Irving', 'Brooklyn Nets', 181.83,81, 27.9),
(12, 'Kevin', 'Durant', 'Brooklyn Nets', 212.01,110, 20.3),
(13, 'Devin', 'Booker', 'Phoenix Suns', 190.11, 92, 21.5),
(14, 'James', 'Harden', 'Brooklyn Nets', 192.66, 110, 23.1),
(15, 'Giannis', 'Antetokounmpo', 'Milwaukee Bucks', 222.00,110, 29.1);