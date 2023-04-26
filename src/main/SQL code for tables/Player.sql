CREATE TABLE Player ( id int NOT NULL AUTO_INCREMENT,
    first_Name VARCHAR(50) NOT NULL,
    last_Name VARCHAR(50) NOT NULL,
    team VARCHAR(50) ,
    height_in_Cm DECIMAL(13, 2) NOT NULL,
	 weight_in_Kg INT NOT NULL,
    points_Per_Game FLOAT  NOT NULL,
    PRIMARY KEY(id)
--   	FOREIGN KEY(team) REFERENCES Teams(team)
);

INSERT INTO Player VALUES
(1, 'LeBron', 'James', 'Los_Angeles_Lakers', 209.12, 115, 25.0),
(2, 'Anthony', 'Davis', 'Los_Angeles_Lakers', 220.75, 110, 23.3),
(3, 'Stephen', 'Curry', 'Golden_State_Warriors', 190.43, 85, 25.5),
(4, 'Trae', 'Young', 'Atlanta_Hawks', 185.98,80, 23.5),
(5, 'Jimmy', 'Butler', 'Miami_Heat', 200.76, 110, 22.2),
(6, 'Luka', 'Doncic', 'Dallas_Mavericks', 200.36, 99, 26.6),
(7, 'Kawhi', 'Leonard', 'Los_Angeles_Clippers', 201.28, 100, 25.0),
(8, 'Joel', 'Embiid', 'Philadelphia_76ers', 215.50,115, 27.3),
(9, 'Damian', 'Lillard', 'Portland_Trail_Blazers', 180.12, 85, 21.1),
(10, 'Nikola', 'Jokic', 'Denver_Nuggets', 214.09,130, 26.4),
(11, 'Kyrie', 'Irving', 'Brooklyn_Nets', 181.83,81, 27.9),
(12, 'Kevin', 'Durant', 'Brooklyn_Nets', 212.01,110, 20.3),
(13, 'Devin', 'Booker', 'Phoenix_Suns', 190.11, 92, 21.5),
(14, 'James', 'Harden', 'Brooklyn_Nets', 192.66, 110, 23.1),
(15, 'Giannis', 'Antetokounmpo', 'Milwaukee_Bucks', 222.00,110, 29.1);
