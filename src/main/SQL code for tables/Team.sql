CREATE TABLE Teams(
    team VARCHAR(30),
    team_city VARCHAR(30),
    team_state VARCHAR(30),
    conference VARCHAR(30),
    division VARCHAR(30),
    arena_ID INT  NOT NULL,
	PRIMARY KEY(team),
	FOREIGN KEY(arena_ID) REFERENCES ARENA(arena_ID)
);

/*You must turn off Enable Foreign key checks when creating table   */

INSERT INTO Teams VALUES
('Los Angeles Lakers','Los Angles','California','Western','Pacific',112345),
('Golden State Warriors','San Fansisco','California','Western','Pacific',212245),
('Atlanta Hawks','Atlanta','Georgia','Eastern','Atlantic',333345),
('Miami Heat','Miami','Florida','Eastern','South East',442344),
('Dallas Mavericks','Dallas','Texas','Western','South West',512555),
('Los Angeles Clippers','Los Angles','California','Western','Pacific',166366),
('Philadelphia 76ers','Philadelphia','Pennsylvania','Eastern','Atlantic',772345),
('Denver Nuggets','Denver','Colorado','Western','North West',888845),
('Portland Trail Blazers','Portland','Oregon','Western','North West',912345),
('Brooklyn Nets','Brooklyn','New York','Eastern','Atlantic',102305),
('Phoenix Suns','Phoenix','Arizona','Western','Pacific',112110),
('Milwaukee Bucks','Milwaukee','Wisconsin','Eastern','Central',121210);

