-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Maj 2021, 19:36
-- Wersja serwera: 10.4.13-MariaDB
-- Wersja PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `quiz`
--
CREATE DATABASE IF NOT EXISTS `quiz` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quiz`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `answers`
--

CREATE TABLE `answers` (
  `id` bigint(20) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `is_correct` bit(1) NOT NULL,
  `question_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `answers`
--

INSERT INTO `answers` (`id`, `answer`, `is_correct`, `question_id`) VALUES
(5, '476', b'1', 2),
(6, '466', b'0', 2),
(7, '483', b'0', 2),
(8, '485', b'0', 2),
(9, 'Arabowie', b'1', 3),
(10, 'Bretończycy', b'0', 3),
(11, 'Baskowie', b'0', 3),
(12, 'Aragończycy', b'0', 3),
(13, 'Stefan I Święty', b'0', 4),
(14, 'Włodzimierz I Wielki', b'0', 4),
(15, 'Otton III', b'1', 4),
(16, 'Bolesław III Rudy', b'0', 4),
(17, 'gruźlicy', b'0', 5),
(18, 'jaczarnej ospy', b'0', 5),
(19, 'dżumy', b'1', 5),
(20, 'tyfusu plamistego', b'0', 5),
(21, '1509', b'0', 6),
(22, '1530', b'0', 6),
(23, '1523', b'0', 6),
(24, '1517', b'1', 6),
(25, 'Zygmunt I Stary', b'1', 7),
(26, 'Henryk Walezy', b'0', 7),
(27, 'Jan I Olbracht', b'0', 7),
(28, 'Zygmunt II August', b'0', 7),
(29, '1670-1700', b'0', 8),
(30, '1618-1648', b'1', 8),
(31, '1602-1632', b'0', 8),
(32, '1629-1659', b'0', 8),
(33, '9', b'0', 9),
(34, '12', b'0', 9),
(35, '18', b'0', 9),
(36, '13', b'1', 9),
(37, 'Rosja i Austria', b'0', 10),
(38, 'Austria i Prusy', b'0', 10),
(39, 'Austria, Prusy i Rosja', b'0', 10),
(40, 'Prusy i Rosja', b'1', 10),
(41, 'Hiszpania', b'0', 11),
(42, 'Dania', b'0', 11),
(43, 'Rosja', b'0', 11),
(44, 'Prusy', b'1', 11),
(45, 'Szwecja', b'0', 12),
(46, 'Turcja', b'1', 12),
(47, 'Austria', b'0', 12),
(48, 'Francja', b'0', 12),
(49, 'w Sudanie', b'1', 13),
(50, 'w Ugandzie', b'0', 13),
(51, 'w Keni', b'0', 13),
(52, 'w Nigerii', b'0', 13),
(53, 'Belgia', b'0', 14),
(54, 'Bułgaria', b'1', 14),
(55, 'Rumunia', b'0', 14),
(56, 'Serbia', b'0', 14),
(57, '8 lipca 1945', b'0', 15),
(58, '9 maja 1945', b'0', 15),
(59, '20 października 1945', b'0', 15),
(60, '2 września 1945', b'1', 15),
(61, '1962-1975', b'1', 16),
(62, '1956-1961', b'0', 16),
(63, '1965-1983', b'0', 16),
(64, '1971-1974', b'0', 16),
(65, 'Zygmunt II August', b'0', 17),
(66, 'Zygmunt II Prawy', b'0', 17),
(67, 'Kazimierz IV Jagiellończyk', b'1', 17),
(68, 'Olbracht Jagiellończyk', b'0', 17),
(69, 'Zygmunta II Augusta', b'0', 18),
(70, 'Zygmunta I Starego', b'1', 18),
(71, 'Władysława II Jagiełły', b'0', 18),
(72, 'Kazimierza IV Jagiellończyka', b'0', 18),
(73, 'Rosji', b'1', 19),
(74, 'Prus', b'0', 19),
(75, 'Węgier', b'0', 19),
(76, 'Austrii', b'0', 19),
(77, 'lwami', b'0', 20),
(78, 'słoniami', b'1', 20),
(79, 'tygrysami', b'0', 20),
(80, 'wielbładami', b'0', 20),
(81, 'w 966 roku', b'0', 21),
(82, 'w 967 roku', b'0', 21),
(83, 'w 956 roku', b'0', 21),
(84, 'w 955 roku', b'1', 21),
(252, 'Estonia', b'0', 63),
(251, 'Finlandia', b'0', 63),
(241, 'Szwajcarii', b'0', 61),
(242, 'Chorwacji', b'0', 61),
(243, 'Włoch', b'0', 61),
(244, 'Hiszpanii', b'1', 61),
(245, 'Apeniny', b'0', 62),
(246, 'Góry Ural', b'1', 62),
(247, 'Karpaty', b'0', 62),
(248, 'Bałkany', b'0', 62),
(249, 'Norwegia', b'1', 63),
(250, 'Szwecja', b'0', 63),
(240, 'W Estonii', b'0', 60),
(237, 'W Norwegii', b'1', 60),
(238, 'W Holandii', b'0', 60),
(239, 'W Austrii', b'0', 60),
(217, 'Monte Rosa', b'0', 55),
(218, 'Gerlach', b'0', 55),
(219, 'Mount Blanc', b'1', 55),
(220, 'Góra Kościuszki', b'0', 55),
(221, 'Skopje', b'0', 56),
(222, 'Varna', b'0', 56),
(223, 'Sofia', b'1', 56),
(224, 'Zagrzeb', b'0', 56),
(225, 'wyspa', b'1', 57),
(226, 'miasto', b'0', 57),
(227, 'nazwa wybrzeża', b'0', 57),
(228, 'państwo', b'0', 57),
(229, 'Włochy od Tunezji', b'0', 58),
(230, 'Europę od Afryki', b'1', 58),
(231, 'Francję od Wielkiej Brytanii', b'0', 58),
(232, 'Danię od Szwecji', b'0', 58),
(233, 'Szwecji', b'0', 59),
(234, 'Norwegii', b'0', 59),
(235, 'Niemiec', b'0', 59),
(236, 'Danii', b'1', 59),
(253, '1 godzina', b'1', 64),
(254, '1 godzina i 15 minut', b'0', 64),
(255, '45 minut', b'0', 64),
(256, '1 godzina i 30 minut', b'0', 64),
(257, '98', b'1', 65),
(258, '99', b'0', 65),
(259, '97', b'0', 65),
(260, 'Tej samej', b'0', 65),
(261, '4', b'0', 66),
(262, '9', b'0', 66),
(263, '6', b'1', 66),
(264, '8', b'0', 66),
(265, '24', b'0', 67),
(266, '25', b'1', 67),
(267, '12', b'0', 67),
(268, '7', b'0', 67),
(269, 'Mars', b'0', 68),
(270, 'kalendarz', b'0', 68),
(271, 'Biegun północny', b'0', 68),
(272, 'Słownik języka polskiego', b'1', 68),
(273, '6', b'1', 69),
(274, '5', b'0', 69),
(275, '10', b'0', 69),
(276, '11', b'0', 69),
(277, '7', b'0', 70),
(278, '29', b'0', 70),
(279, '23', b'1', 70),
(280, '20', b'0', 70),
(281, '10zł', b'0', 71),
(282, '5zł', b'1', 71),
(283, '2zł', b'0', 71),
(284, '20zł', b'0', 71),
(285, '65', b'0', 72),
(286, '54', b'0', 72),
(287, '9', b'0', 72),
(288, '12', b'1', 72),
(289, 'Zbyt mało danych, by odpowiedzieć na to pytanie.', b'1', 73),
(290, '10km', b'0', 73),
(291, '30km', b'0', 73),
(292, '40km', b'0', 73),
(293, 'Madonna', b'1', 74),
(294, 'Roxette', b'0', 74),
(295, '1 godzina i 15 minut', b'0', 74),
(296, 'Nena', b'0', 74),
(297, 'Billie Jean', b'1', 75),
(298, 'I Want You Back', b'0', 75),
(299, 'The Love You Save', b'0', 75),
(300, 'I\'ll Be There', b'0', 75),
(301, 'Pitbull', b'0', 76),
(302, 'Usher', b'0', 76),
(303, 'Chros Brown', b'0', 76),
(304, 'Akon', b'1', 76),
(305, '2012', b'0', 77),
(306, '2077', b'0', 77),
(307, '2008', b'1', 77),
(308, '2006', b'0', 77),
(309, 'T-Pain', b'0', 78),
(310, 'Ne-Yo', b'1', 78),
(311, 'Trey Songz', b'0', 78),
(312, 'Tory Lanez', b'0', 78),
(313, 'Dire Straits', b'0', 79),
(314, 'AC/DC', b'0', 79),
(315, 'Pink Floyd', b'1', 79),
(316, 'Deep Purple', b'0', 79),
(317, 'Oasis', b'0', 80),
(318, 'Radiohead', b'0', 80),
(319, 'Led Zeppelin', b'0', 80),
(320, 'Metallica', b'1', 80),
(321, 'Kazachstan', b'0', 81),
(322, 'USA', b'1', 81),
(323, 'Wielka Brytania', b'0', 81),
(324, 'Niemcy', b'0', 81),
(325, '1960', b'1', 82),
(326, '1965', b'0', 82),
(327, '1967', b'0', 82),
(328, '1963', b'0', 82),
(329, '1969', b'0', 83),
(330, '1970', b'0', 83),
(331, '1980', b'0', 83),
(332, '1971', b'1', 83),
(333, 'Bob Marley', b'0', 84),
(334, 'Bobby McFerrin', b'1', 84),
(335, 'Chick Corea', b'0', 84),
(336, 'Greg Osby', b'0', 84),
(337, 'Tim Berners-Lee', b'0', 85),
(338, 'Peter Armbruster', b'0', 85),
(339, 'David R. Scott', b'1', 85),
(340, 'Walter Lewin', b'0', 85),
(341, '3', b'1', 86),
(342, '1', b'0', 86),
(343, '5', b'0', 86),
(344, '6', b'0', 86),
(345, 'Emile Berliner', b'1', 87),
(346, 'Einstein', b'0', 87),
(347, 'Thomas Edison', b'0', 87),
(348, 'Valdemar Poulsen', b'0', 87),
(349, 'Cztery i pół roku', b'0', 88),
(350, 'Pięć lat', b'0', 88),
(351, 'Dwa lata', b'0', 88),
(352, 'Dziewięć i pół roku', b'1', 88),
(353, 'Chromosom X', b'0', 89),
(354, 'Chromosom 4', b'0', 89),
(355, 'Chromosom 1', b'1', 89),
(356, 'Chromosom 17', b'0', 89),
(357, '23', b'0', 90),
(358, '83', b'0', 90),
(359, '89%', b'0', 90),
(360, '99%', b'1', 90),
(361, 'Stal', b'1', 91),
(362, 'Powietrze', b'0', 91),
(363, 'Guma', b'0', 91),
(364, 'Woda', b'0', 91),
(365, 'rok', b'0', 92),
(366, '200 miliardów lat', b'1', 92),
(367, '20 lat', b'0', 92),
(368, '2000 lat', b'0', 92),
(369, '380 ° C', b'0', 93),
(370, '440 ° C', b'0', 93),
(371, '420 ° C', b'0', 93),
(372, '460 ° C', b'1', 93),
(373, 'Jonizacji', b'0', 94),
(374, 'Mechaniczną', b'0', 94),
(375, 'Potencjalną', b'1', 94),
(376, 'Kinetyczną', b'0', 94),
(377, 'rodzina szczęśliwa', b'0', 95),
(378, 'przychodzi gorsza bida', b'0', 95),
(379, 'gdy głowina siwa', b'0', 95),
(380, 'cnota ubywa', b'1', 95),
(381, 'czego tykać nie chcesz', b'0', 96),
(382, 'póki nie zapłacisz', b'0', 96),
(383, 'gdzieś nie położył', b'1', 96),
(384, 'czegoś nie zgubił', b'0', 96),
(385, 'chłodne wieczory i ranki', b'1', 97),
(386, 'grzybów pełne saganki', b'0', 97),
(387, 'poszły w niepamięć kochanki', b'0', 97),
(388, 'tłuką się dzbanki', b'0', 97),
(389, 'tym trudniej ją rozbić', b'0', 98),
(390, 'tym na starość trąci', b'1', 98),
(391, 'tym po latach śmierdzi', b'0', 98),
(392, 'tym ją na starość w złą stronę pociągniesz', b'0', 98),
(393, 'ale to kula wybiera', b'0', 99),
(394, 'Pan Bóg kule nosi', b'1', 99),
(395, 'diabeł ręce zaciera', b'0', 99),
(396, 'anioł mu ręką kieruje', b'0', 99),
(397, 'tam chłop nie błądzi', b'0', 100),
(398, 'szkody wyrządzi', b'0', 100),
(399, 'tam diabeł błądzi', b'1', 100),
(400, 'tylko Bóg osądzi', b'0', 100),
(401, 'tam nie ma co jeść', b'1', 101),
(402, 'tam pobite gary', b'0', 101),
(403, 'tam nóżek dwanaście', b'0', 101),
(404, 'tam będziesz mógł dobrze zjeść', b'0', 101),
(405, 'krzyżem', b'0', 102),
(406, 'podporą', b'0', 102),
(407, 'diabłem', b'0', 102),
(408, 'wilkiem', b'1', 102),
(409, 'nie ma kołaczy', b'1', 103),
(410, 'człowiek się łajdaczy', b'0', 103),
(411, 'nie ma pieniędzy na tacy', b'0', 103),
(412, 'ludzie biedacy', b'0', 103),
(413, 'niech się między bajki schowa', b'0', 104),
(414, 'pożałujesz każdego słowa', b'0', 104),
(415, 'pisz na bystrej wodzie jej słowa', b'1', 104),
(416, 'spuchnie od tego twa głowa', b'0', 104),
(417, 'bo koń zdechł', b'0', 105),
(418, 'dziecię nie', b'0', 105),
(419, 'a chłop za nią', b'0', 105),
(420, 'koniom lżej', b'1', 105),
(421, 'uczy rozumu', b'1', 106),
(422, 'każdemu w czym innym', b'0', 106),
(423, 'każdemu ciężka', b'0', 106),
(424, 'nie zna snu', b'0', 106),
(425, 'ale zjadła owca wilka', b'0', 107),
(426, 'teraz noszą futro z wilka', b'0', 107),
(427, 'przyszedł czas i na wilka', b'0', 107),
(428, 'ponieśli i wilka', b'1', 107),
(429, 'to nic nie wskóra', b'0', 108),
(430, 'to baba poprawiać będzie', b'0', 108),
(431, 'a problemów będzie góra', b'0', 108),
(432, 'to atrament wypije', b'1', 108),
(433, 'pracować trzeba', b'0', 109),
(434, 'nie dla nieba', b'1', 109),
(435, 'pierwsza potrzeba', b'0', 109),
(436, 'czasem ubrudzić się trzeba', b'0', 109),
(437, '0', b'1', 110),
(438, '1', b'0', 110),
(439, '2', b'0', 110),
(440, '4', b'0', 110),
(441, '5', b'0', 111),
(442, '6', b'0', 111),
(443, '7', b'1', 111),
(444, '8', b'0', 111),
(445, '5000 m', b'0', 112),
(446, '15000 m', b'0', 112),
(447, '1000 m', b'0', 112),
(448, '10000 m', b'1', 112),
(449, '5', b'0', 113),
(450, '6', b'1', 113),
(451, '7', b'0', 113),
(452, '12', b'0', 113),
(453, '2012', b'1', 114),
(454, '2010', b'0', 114),
(455, '2016', b'0', 114),
(456, '2008', b'0', 114),
(457, 'Michael Phelps', b'1', 115),
(458, 'Usain Bolt', b'0', 115),
(459, 'Mark Spitz', b'0', 115),
(460, 'Carl Lewis', b'0', 115),
(461, 'Eric Armstrong', b'0', 116),
(462, 'Neil Armstrong', b'0', 116),
(463, 'Louis Armstrong', b'0', 116),
(464, 'Lance Armstrong', b'1', 116),
(465, 'Szermierka', b'0', 117),
(466, 'Sumo', b'1', 117),
(467, 'Judo', b'0', 117),
(468, 'Boks', b'0', 117),
(469, 'Asafa Powell', b'0', 118),
(470, 'Andre de Grasse', b'0', 118),
(471, 'Tyson Gay', b'0', 118),
(472, 'Usain Bolt', b'1', 118),
(473, '4', b'1', 119),
(474, '2', b'0', 119),
(475, '6', b'0', 119),
(476, '7', b'0', 119),
(477, 'Nart', b'0', 120),
(478, 'Łyżew', b'1', 120),
(479, 'Karabinów', b'0', 120),
(480, 'Nart oraz kijków', b'0', 120),
(481, 'Walka karnawału z postem', b'0', 121),
(482, 'Zabawy dziecięce', b'0', 121),
(483, 'Wiejski taniec', b'0', 121),
(484, 'Ogród rozkoszy ziemskich', b'1', 121),
(485, 'Michał Anioł', b'0', 122),
(486, 'Gianlorenzo Bernini', b'1', 122),
(487, 'Leonardo da Vinci', b'0', 122),
(488, 'Donatello', b'0', 122),
(489, 'Aleksander Gierymski', b'0', 123),
(490, 'Władysław Podkowiński', b'1', 123),
(491, 'Józef Chełmoński', b'0', 123),
(492, 'Leon Wyczółkowski', b'0', 123),
(493, 'Caravaggio', b'0', 124),
(494, 'Rafaela', b'0', 124),
(495, 'Tycjana', b'0', 124),
(496, 'El Greco', b'1', 124),
(497, 'z czekolady', b'0', 125),
(498, 'z wosku', b'1', 125),
(499, 'z brązu', b'0', 125),
(500, 'z gliny', b'0', 125),
(501, 'Salvador Dali', b'1', 126),
(502, 'Andy Warhol', b'0', 126),
(503, 'Marcel Duchamp', b'0', 126),
(504, 'Jackson Pollock', b'0', 126),
(505, 'XVII', b'0', 127),
(506, 'XVI', b'0', 127),
(507, 'XVIII', b'1', 127),
(508, 'XV', b'0', 127),
(509, 'w Kaplicy Sykstyńskiej w Watykanie', b'0', 128),
(510, 'w jednym z klasztorów w Mediolanie', b'1', 128),
(511, 'w jednym z kościołów w Padwie', b'0', 128),
(512, 'w Pałacu Medyceuszy we Florencji', b'0', 128),
(513, 'został skradziony z muzeum w latach 90 i do tej pory go nie odnaleziono', b'0', 129),
(514, 'przechwycono go na granicy polsko-rosyjskiej podczas próby przemytu', b'0', 129),
(515, 'malowało go kilka osób', b'0', 129),
(516, 'zrabowano go w czasie wojny i niedawno został odnaleziony', b'1', 129),
(517, 'baroku', b'1', 130),
(518, 'klasycyzmu', b'0', 130),
(519, 'średniowiecza', b'0', 130),
(520, 'renesansu', b'0', 130),
(521, 'LG Electronics', b'0', 131),
(522, 'Microsoft', b'0', 131),
(523, 'Samsung', b'1', 131),
(524, 'Apple', b'0', 131),
(525, 'Tirana', b'0', 132),
(526, 'Budapeszt', b'0', 132),
(527, 'Wiedeń', b'0', 132),
(528, 'Lizbona', b'1', 132),
(529, 'Philip Henry Gosse', b'0', 133),
(530, 'Peter Durand', b'1', 133),
(531, 'Ferenc Erkel', b'0', 133),
(532, 'Henry Cavendish', b'0', 133),
(533, '7', b'1', 134),
(534, '6', b'0', 134),
(535, '8', b'0', 134),
(536, '4', b'0', 134),
(537, '11 września 2001 r.', b'1', 135),
(538, '11 lipca 2001 r.', b'0', 135),
(539, '11 listopada 2001 r.', b'0', 135),
(540, '11 października 2001 r.', b'0', 135),
(541, 'Mussoliniego', b'0', 136),
(542, 'Stalina', b'0', 136),
(543, 'Hitlera', b'1', 136),
(544, 'Hessa', b'0', 136),
(545, 'Ocean Arktyczny', b'0', 137),
(546, 'Ocean Indyjski', b'0', 137),
(547, 'Ocean Atlantycki', b'0', 137),
(548, 'Ocean Spokojny', b'1', 137),
(549, 'Amerykaninem', b'1', 138),
(550, 'Włochem', b'0', 138),
(551, 'Francuzem', b'0', 138),
(552, 'Szkotem', b'0', 138),
(553, '1170', b'0', 139),
(554, '1047', b'1', 139),
(555, '996', b'0', 139),
(556, '1241', b'0', 139),
(557, 'taoizm', b'0', 140),
(558, 'hinduizm', b'0', 140),
(559, 'chreścijaństwo', b'0', 140),
(560, 'szinto', b'1', 140),
(561, 'Egipt', b'1', 141),
(562, 'Włochy', b'0', 141),
(563, 'Grecja', b'0', 141),
(564, 'Stany Zjednoczone', b'0', 141),
(565, 'Egipt', b'0', 142),
(566, 'Włochy', b'1', 142),
(567, 'Grecja', b'0', 142),
(568, 'Stany Zjednoczone', b'0', 142),
(569, 'Indie', b'0', 143),
(570, 'Kuwejt', b'0', 143),
(571, 'Egipt', b'0', 143),
(572, 'Kambodża', b'1', 143),
(573, 'Wielka Brytania', b'0', 144),
(574, 'USA', b'1', 144),
(575, 'Niemcy', b'0', 144),
(576, 'Hiszpania', b'0', 144),
(577, 'Australia', b'1', 145),
(578, 'Wielka Brytania', b'0', 145),
(579, 'Stany Zjednoczone', b'0', 145),
(580, 'Francja', b'0', 145),
(581, 'Kuwejt', b'0', 146),
(582, 'Australia', b'0', 146),
(583, 'Peru', b'0', 146),
(584, 'Indie', b'1', 146),
(585, 'Korea Północna', b'1', 147),
(586, 'Korea Południowa', b'0', 147),
(587, 'Jordana', b'0', 147),
(588, 'Argentyna', b'0', 147),
(589, 'Berlin', b'0', 148),
(590, 'Paryż', b'0', 148),
(591, 'Kuwejt', b'1', 148),
(592, 'Zagrzeb', b'0', 148),
(593, 'Indonezja', b'0', 149),
(594, 'Iran', b'1', 149),
(595, 'Wietnam', b'0', 149),
(596, 'Kuba', b'0', 149),
(597, 'Wielka Brytania', b'1', 150),
(598, 'Niemcy', b'0', 150),
(599, 'Słowacja', b'0', 150),
(600, 'USA', b'0', 150),
(601, 'Leszcz', b'0', 151),
(602, 'Karp', b'0', 151),
(603, 'Szczupak', b'1', 151),
(604, 'Płoć', b'0', 151),
(605, 'Ssaki', b'1', 152),
(606, 'Naczelne', b'0', 152),
(607, 'Strunowce', b'0', 152),
(608, 'Łożyskowce', b'0', 152),
(609, 'Gibon', b'0', 153),
(610, 'Orangutan', b'0', 153),
(611, 'Goryl', b'0', 153),
(612, 'Szympans', b'1', 153),
(613, 'Żyrafa', b'0', 154),
(614, 'Sarna', b'0', 154),
(615, 'Świnia', b'0', 154),
(616, 'Wszystkie odpowiedzi są poprawne.', b'1', 154),
(617, 'Rybami', b'0', 155),
(618, 'Są wszystkożerne', b'1', 155),
(619, 'Małymi ssakami', b'0', 155),
(620, 'Roślinami', b'0', 155),
(621, 'Kazuar', b'1', 156),
(622, 'Kaczka', b'0', 156),
(623, 'Głuszec', b'0', 156),
(624, 'Pelikan', b'0', 156),
(629, 'Gile', b'0', 158),
(630, 'Sikorki', b'0', 158),
(631, 'Perkozy', b'1', 158),
(632, 'Kolibry', b'0', 158),
(633, '8', b'0', 159),
(634, '16', b'1', 159),
(635, '12', b'0', 159),
(636, '6', b'0', 159),
(637, 'Królewski', b'0', 160),
(638, 'Cesarski', b'1', 160),
(639, 'Białobrewy', b'0', 160),
(640, 'Magellański', b'0', 160),
(641, '5 mln lat', b'0', 161),
(642, '10 mln lat', b'0', 161),
(643, '50 mln lat', b'0', 161),
(644, '100 mln lat', b'1', 161),
(645, 'Unosi się ku górze w celu odstraszenia przeciwnika', b'0', 162),
(646, 'Zawsze zwisa w dół', b'1', 162),
(647, 'Unosi się ku górze tylko podczas kopulacji', b'0', 162),
(648, 'Merda jak u psa', b'0', 162);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `questions`
--

CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL,
  `available` bit(1) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `seconds` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `questions`
--

INSERT INTO `questions` (`id`, `available`, `category`, `content`, `points`, `seconds`, `author`) VALUES
(2, b'1', 'Historia', 'W którym roku naszej ery nastąpił ostateczny upadek Cesarstwa Zachodniorzymskiego?', 1, 15, NULL),
(3, b'1', 'Historia', 'Jaki lud został pokonany przez Karola Młota w 732 roku w bitwie pod Poitiers?', 3, 20, NULL),
(4, b'1', 'Historia', 'Który władca był gościem Bolesława Chrobrego podczas zjazdu gnieźnieńskiego w roku 1000?', 2, 20, NULL),
(5, b'1', 'Historia', 'Epidemia jakiej choroby spustoszyła Europę w połowie XIV wieku powodując śmierć blisko co trzeciego Europejczyka?', 2, 15, NULL),
(6, b'1', 'Historia', 'W którym roku Marcin Luter przybił swoje 95 tez na drzwiach kościoła w Wittenberdze i rozpoczął Reformację religijną?', 1, 20, NULL),
(7, b'1', 'Historia', 'Który król Polski zakończył swoje panowanie w 1548 roku?', 3, 20, NULL),
(8, b'1', 'Historia', 'W jakich latach toczyła się wojna trzydziestoletnia?', 4, 15, NULL),
(9, b'1', 'Historia', 'Na ile kolonii podzielone było brytyjskie terytorium w Ameryce Północnej na początku amerykańskiej walki o niepodległość (1775)?', 5, 20, NULL),
(10, b'1', 'Historia', 'Które kraje dokonały II rozbioru Polski w 1793 roku?', 2, 30, NULL),
(11, b'1', 'Historia', 'Który z poniższych krajów należał do koalicji państw, która pokonała Napoleona pod Waterloo w 1815 roku?', 3, 30, NULL),
(12, b'1', 'Historia', 'Jaki kraj był głównym przeciwnikiem Rosji w czasie wojny krymskiej w latach 1853-1856?', 2, 20, NULL),
(13, b'1', 'Historia', 'W którym skolonizowanym kraju w latach 1881-1899 miało miejsce Powstanie Mahdiego, skierowane przeciwko Wielkiej Brytanii i współpracującemu z nią Egiptowi?', 5, 30, NULL),
(14, b'1', 'Historia', 'Który z poniższych krajów walczył po stronie Państw Centralnych w czasie I wojny światowej?', 3, 20, NULL),
(15, b'1', 'Historia', 'Którego dnia Cesarstwo Japonii  podpisało kapitulację ostatecznie kończącą II wojnę światową?', 6, 30, NULL),
(16, b'1', 'Historia', 'W jakich latach trwała wojna w Wietnamie pomiędzy komunistycznym Wietnamem Północnym i proamerykańskim Wietnamem Południowym?', 4, 30, NULL),
(17, b'1', 'Historia', 'Najmłodszym synem Władysława II Jagiełły był:', 1, 20, NULL),
(18, b'1', 'Historia', 'Kogo żoną była Bona Sforza?', 1, 30, NULL),
(19, b'1', 'Historia', 'Katarzyna II Wielka była cesarzową', 1, 20, NULL),
(20, b'1', 'Historia', 'Z którymi zwierzętami Hannibal przeprawił się przez Alpy', 1, 30, NULL),
(21, b'0', NULL, 'Kiedy Polska przyjęła chrzest?', NULL, 30, 'dwq'),
(55, b'1', 'Geografia', 'Najwyższy szczyt górski położony w Europie to:', 3, 30, 'asdf'),
(56, b'1', 'Geografia', 'Stolica Bułgarii:', 1, 30, 'asdf'),
(57, b'1', 'Geografia', 'Teneryfa to:', 4, 30, 'asdf'),
(58, b'1', 'Geografia', 'Cieśnina Gibraltarska oddziela:', 3, 30, 'asdf'),
(59, b'1', 'Geografia', 'Wyspa Bornholm należy do:', 2, 30, 'asdf'),
(60, b'1', 'Geografia', 'W jakim państwie znajduje się Haga?', 2, 30, 'asdf'),
(62, b'0', NULL, 'Granicę Europa - Azja wyznaczają między innymi:', NULL, 30, 'cfty'),
(61, b'1', 'Geografia', 'Pireneje sa położone na terytorium:', 2, 30, 'asdf'),
(63, b'1', 'Geografia', 'Które z podanych państw jest najbardziej wysunięte na zachód?', 4, 15, 'cfty'),
(64, b'1', 'Logika', 'Marcina rozbolała głowa. Lekarz dał mu 5 tabletek przeciwbólowych i polecił brać jedna co 15 minut. Ile czasu zajęło połknięcie ich wszystkich?', 5, 30, 'cfty'),
(65, b'0', NULL, 'Bierzesz udział w wyścigu kolarskim. Wyprzedzasz osobę na 98 pozycji. Który jesteś?', NULL, 15, 'cfty'),
(66, b'1', 'Logika', 'Marysia upiekła 78 ciasteczek i ułożyła taką samą ilość na osobnych talerzykach. Ile ciasteczek było na pojedynczym talerzyku?', 3, 15, 'cfty'),
(67, b'1', 'Logika', '3 znajomych kolekcjonuje figurki. Marta ma ich dwa razy tyle, co Kinga. Robert ma o jedną więcej niż Marta. Kinga posiada 12 figurek, zatem ile posiada Robert?', 3, 20, 'cfty'),
(68, b'1', 'Logika', 'Na Ziemi dzisiaj jest zawsze po wczoraj, ale jest miejsce, gdzie wczoraj zawsze występuje po dzisiaj. Jakie to miejsce?', 4, 15, 'cfty'),
(69, b'1', 'Logika', 'Krzysztof i Barbara mają 5 córek. Każda córka ma 1 brata. Ile dzieci mają Krzysztof i Barbara?', 4, 15, 'franek'),
(70, b'1', 'Logika', 'Farmer ma na farmie kury i krowy. W sumie posiada 30 zwierząt, a te posiadają łącznie 74 nogi. Ile kur posiada farmer?', 5, 25, 'franek'),
(71, b'1', 'Logika', 'W sklepie z biżuterią można kupić pierścionek wraz z pudełkiem za 200zł. Pierścionek kosztuje 190zł więcej niż pudełko. Ile kosztuje pudełko?', 4, 15, 'franek'),
(72, b'1', 'Logika', 'Na przyjęciu każdy przywitał się z każdym innym uczestnikiem poprzez uściśnięcie dłoni. Wymieniono 66 uścisków, ile osób było na przyjęciu?', 6, 25, 'franek'),
(73, b'1', 'Logika', 'Cztery miejscowości A-B-C-D położone są wzdłuż prostej drogi. Miejscowość A znajduje się 20 km od miejscowości C. Miejscowość B znajduje się 20 km od miejscowości D. Jaka jest odległość pomiędzy miejscowościami A i D?', 6, 30, 'franek'),
(74, b'1', 'Muzyka', 'Która gwiazda lat 80. jest uznawana przez Guinness World Records za najlepiej sprzedającą się artystkę wszechczasów? ', 2, 20, 'franek'),
(75, b'1', 'Muzyka', 'Michael Jackson zadebiutował swoim znakiem firmowym moonwalk podczas której piosenki w 1983 roku?', 3, 15, 'franek'),
(76, b'1', 'Muzyka', 'Który artysta wydał 3 albumy o tematyce więziennej, tzw Nieporządek, Konvicted Wolność w pierwszej dekadzie XXI wieku?', 3, 15, 'franek'),
(77, b'1', 'Muzyka', 'W którym roku ukazał się pierwszy wielki hit Katy Perry „I Kissed a Girl”?', 2, 15, 'franek'),
(78, b'1', 'Muzyka', 'Który artysta otrzymał imię od producenta, który twierdził, że „widzi muzykę tak, jakby to był Matrix”?', 3, 15, 'Grzegorz'),
(79, b'1', 'Muzyka', '\"Another Brick in the Wall\", \"Money\", \"Wish You Were Here\" to jedne z najbardziej znanych utworów zespołu rockowego:', 3, 15, 'Grzegorz'),
(80, b'1', 'Muzyka', 'Która grupa nie pochodzi z Wielkiej Brytanii?', 2, 20, 'Grzegorz'),
(81, b'1', 'Muzyka', 'W którym kraju ma swoje korzenie rock?', 3, 25, 'TomekPL'),
(82, b'0', NULL, 'W którym roku założono The Beatles?', NULL, 15, 'TomekPL'),
(83, b'1', 'Muzyka', 'Utwór \"Stairway to Heaven\" autorstwa Led Zeppelin został wydany w ', 2, 15, 'TomekPL'),
(84, b'0', NULL, 'Wykonawcą utworu \"Don\'t worry, be happy\" jest', NULL, 15, 'TomekPL'),
(85, b'1', 'Nauka', 'Kto zrzucił na Księżyc młot i pióro, aby pokazać, że bez powietrza spadają w tym samym tempie?', 3, 15, 'TomekPL'),
(86, b'0', NULL, 'Ile serc ma ośmiornica?', NULL, 20, 'masterPro'),
(87, b'1', 'Nauka', 'Kto wynalazł gramofon?', 2, 15, 'masterPro'),
(88, b'1', 'Nauka', 'Ile lat zajmie wystrzelenie statku kosmicznego z Ziemi na planetę Pluton?', 4, 15, 'masterPro'),
(89, b'1', 'Nauka', 'Jaka jest największa cząsteczka stanowiąca część ludzkiego ciała?', 5, 20, 'masterPro'),
(90, b'1', 'Nauka', 'Jaki procent masy Układu Słonecznego znajduje się w Słońcu?', 2, 15, 'qsdre'),
(91, b'1', 'Nauka', 'Gdzie powstały pierwsze animacje komputerowe?', 2, 15, 'qsdre'),
(92, b'1', 'Nauka', 'Gdybyś mógł przetworzyć miliard atomów na sekundę, ile lat zajęłaby teleportacja typowego człowieka?', 5, 25, 'qsdre'),
(93, b'0', NULL, 'Jaka jest średnia temperatura powierzchni na Wenus?', NULL, 15, 'takO'),
(94, b'1', 'Nauka', 'Jaką energię posiada stojący w miejscu rower?', 1, 15, 'takO'),
(95, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Bogactwo przybywa...', 1, 15, 'git123'),
(96, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Nie bierz...', 2, 15, 'git123'),
(97, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Od świętej Anki...', 4, 15, 'git123'),
(98, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Czym skorupka za młodu nasiąknie...', 2, 20, 'git123'),
(99, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Człowiek strzela...', 1, 15, 'git123'),
(100, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Gdzie baba rządzi...', 1, 15, 'git123'),
(101, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Gdzie kucharek sześć...', 1, 15, 'cfty'),
(102, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Człowiek człowiekowi', 2, 5, 'asdf'),
(103, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Bez pracy...', 1, 5, 'asdf'),
(104, b'1', 'Przysłowia polskie', 'Dokończ przysłowie:  Co ci powie białogłowa...', 3, 15, 'asdf'),
(105, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Baba z wozu...', 1, 5, 'asdf'),
(106, b'0', NULL, 'Dokończ przysłowie: Bieda...', NULL, 15, 'Grzegorz'),
(107, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Nosił wilk razy kilka...', 1, 5, 'Grzegorz'),
(108, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Puścić chłopa do biura...', 5, 20, 'ppsm20'),
(109, b'1', 'Przysłowia polskie', 'Dokończ przysłowie: Dla chleba...', 3, 15, 'ppsm20'),
(110, b'0', NULL, 'Ile złotych medali olimpijskich zdobył Adam Małysz?', NULL, 15, 'masterPro'),
(111, b'1', 'Sport', 'Ile najwięcej złotych medali olimpijskich zdobyliśmy na jednych letnich igrzyskach?', 2, 20, 'masterPro'),
(112, b'1', 'Sport', 'Trasa najdłuższego biegu, który rozgrywa się na stadionie, liczy:', 2, 15, 'masterPro'),
(113, b'1', 'Sport', 'Ilu graczy liczy drużyna hokeja na lodzie? Chodzi oczywiście o liczbę graczy na lodowisku', 3, 20, 'masterPro'),
(114, b'1', 'Sport', 'W którym roku odbyły się Mistrzostwa Europy w piłce nożnej, gdy gospodarzem była Polska?', 1, 15, 'masterPro'),
(115, b'1', 'Sport', 'Najwięcej złotych medali w historii Igrzysk Olimpijskich zdobył:', 3, 5, 'takO'),
(116, b'1', 'Sport', 'Kolarz, który wygrał wygrał wyścig kolarski Tour de France 7 razy, po czym został zdyskwalifikowany:', 2, 15, 'takO'),
(117, b'1', 'Sport', 'Która sztuka walki nie jest sportem olimpijskim?', 3, 20, 'vbnm'),
(118, b'1', 'Sport', 'Wielokrotny medalista olimpijski, rekordzista biegów na 100 i 200 metrów:', 2, 5, 'vbnm'),
(119, b'1', 'Sport', 'Ilu graczy jest w olimpijskiej drużynie do curlingu?', 4, 20, 'ppsm20'),
(120, b'1', 'Sport', 'Panczeniści do uprawiania swojego sportu potrzebują:', 1, 15, 'ppsm20'),
(121, b'1', 'Sztuka', 'Autorem którego z poniższych dzieł nie jest Pieter Bruegel (starszy)?', 5, 30, 'asdf'),
(122, b'1', 'Sztuka', 'Kto zaprojektował baldachim nad grobem św. Piotra w Bazylice św. Piotra w Watykanie?', 3, 15, 'asdf'),
(123, b'1', 'Sztuka', 'Kto namalował obraz \"Ulica Nowy Świat w dzień letni\"?', 3, 15, 'asdf'),
(124, b'1', 'Sztuka', '\"Ekstaza św. Franciszka\" została namalowana przez:', 3, 15, 'cfty'),
(125, b'1', 'Sztuka', 'Z jakiego materiału Edgar Degas wyrzeźbił \"Czternastoletnią tancerkę\"?', 6, 15, 'cfty'),
(126, b'1', 'Sztuka', 'Kto zaprojektował logo lizaków Chupa Chups?', 4, 20, 'franek'),
(127, b'1', 'Sztuka', 'W którym wieku założono Łazienki Królewskie w Warszawie?', 3, 15, 'Grzegorz'),
(128, b'0', NULL, 'Gdzie znajduje się \"Ostatnia wieczerza\" Leonarda da Vinci?', NULL, 15, 'masterPro'),
(129, b'1', 'Sztuka', 'Obraz \"Żydówka z pomarańczami\" zasłynął z tego, że:', 6, 20, 'masterPro'),
(130, b'1', 'Sztuka', 'Portret trumienny był charakterystycznym elementem polskiej sztuki z epoki', 3, 15, 'masterPro'),
(131, b'1', 'Wiedza ogólna', 'Jak nazywa się największa firma technologiczna w Korei Południowej?', 1, 15, 'cfty'),
(132, b'1', 'Geografia', 'Jaka jest stolica Portugalii?', 1, 15, 'cfty'),
(133, b'1', 'Wiedza ogólna', 'Kto wynalazł puszkę do konserwowania żywności w 1810 roku?', 4, 20, 'franek'),
(134, b'1', 'Geografia', 'Z iloma krajami graniczy Polska?', 1, 15, 'Grzegorz'),
(135, b'1', 'Wiedza ogólna', 'Data terrorystycznego ataku na WTC to:', 2, 15, 'Grzegorz'),
(136, b'1', 'Wiedza ogólna', '\"Dyktator\" z wybitną rolą Charliego Chaplina parodiował postać:', 2, 15, 'Grzegorz'),
(137, b'1', 'Geografia', 'Największy ocean na Ziemi to?', 2, 15, 'TomekPL'),
(138, b'1', 'Wiedza ogólna', 'Mario Puzo, autor \"Ojca chrzestnego\" był:', 3, 20, 'TomekPL'),
(139, b'1', 'Geografia', 'Najdłuższą rzeką w Polsce jest Wisła. Ile kilometrów mierzy?', 3, 15, 'masterPro'),
(140, b'1', 'Wiedza ogólna', 'Religią dominującą w Japonii jest buddyzm oraz...', 4, 15, 'masterPro'),
(141, b'1', 'Zabytki', 'Gdzie znajduje się Piramida w Gizie i Wielki Sfinks?', 1, 5, 'Grzegorz'),
(142, b'1', 'Zabytki', 'Gdzie znajduje się Koloseum?', 1, 30, 'Grzegorz'),
(143, b'1', 'Zabytki', 'Gdzie znajduje się Angkor Wat?', 4, 20, 'masterPro'),
(144, b'1', 'Zabytki', 'Gdzie znajduje się Statua Wolności?', 1, 15, 'masterPro'),
(145, b'1', 'Zabytki', 'Gdzie znajduje się Sydney Harbour Bridge?', 2, 15, 'masterPro'),
(146, b'1', 'Zabytki', 'Gdzie znajduje się Taj Mahal?', 3, 20, 'masterPro'),
(147, b'1', 'Zabytki', 'Gdzie znajduje się Juche Tower?', 3, 15, 'masterPro'),
(148, b'1', 'Zabytki', 'Gdzie znajdują się Wieże wodne?', 2, 15, 'takO'),
(149, b'1', 'Zabytki', 'Gdzie znajduje się Pomnik Azadi?', 3, 15, 'takO'),
(150, b'0', NULL, 'Gdzie znajduje się Stonehenge?', NULL, 5, 'vbnm'),
(151, b'1', 'Zwierzęta', 'Która z podanych ryb należy do drapieżników?', 1, 15, 'qsdre'),
(152, b'1', 'Zwierzęta', 'Do jakiej gromady należy człowiek?', 1, 15, 'qsdre'),
(153, b'1', 'Zwierzęta', 'Jaki rodzaj małpy jest najbliższy człowiekowi?', 2, 20, 'takO'),
(154, b'1', 'Zwierzęta', 'Parzystokopytne to:', 3, 15, 'takO'),
(155, b'1', 'Zwierzęta', 'Czym żywi się większość niedźwiedzi?', 3, 15, 'git123'),
(156, b'1', 'Zwierzęta', 'Do nielotów należy:', 4, 15, 'git123'),
(158, b'1', 'Zwierzęta', 'Jedynymi ptakami potrafiącymi latać do tyłu są:', 3, 15, 'vbnm'),
(159, b'1', 'Zwierzęta', 'Ile mięśni porusza uszami konia?', 6, 20, 'masterPro'),
(160, b'1', 'Zwierzęta', 'Największym gatunkiem pingwina jest:', 3, 15, 'franek'),
(161, b'1', 'Zwierzęta', 'Kameleony występują na ziemi od co najmniej', 6, 20, 'TomekPL'),
(162, b'1', 'Zwierzęta', 'Ogon wilka:', 5, 20, 'vbnm');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rates`
--

CREATE TABLE `rates` (
  `id` bigint(20) NOT NULL,
  `positive_opinion` bit(1) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `rates`
--

INSERT INTO `rates` (`id`, `positive_opinion`, `user_name`) VALUES
(1, b'0', 'asdf'),
(2, b'1', 'cfty'),
(3, b'1', 'franek'),
(4, b'1', 'git123'),
(5, b'1', 'ppsm20'),
(6, b'1', 'qsdre'),
(7, b'1', 'vbnm'),
(8, b'1', 'fred46'),
(9, b'1', 'anonimos'),
(10, b'1', 'test123');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `results`
--

CREATE TABLE `results` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `points` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `results`
--

INSERT INTO `results` (`id`, `date`, `points`, `user_id`) VALUES
(1, '2020-12-20 12:49:25', 2, 2),
(2, '2020-12-20 13:31:37', 1, 2),
(3, '2020-12-20 13:31:56', 0, 2),
(4, '2020-12-20 13:33:00', 2, 2),
(5, '2020-12-20 13:33:05', 0, 2),
(6, '2020-12-20 13:33:13', 0, 2),
(7, '2020-12-20 13:33:18', 0, 2),
(8, '2020-12-20 13:38:18', 6, 2),
(9, '2020-12-20 13:44:49', 3, 2),
(10, '2020-12-20 13:47:22', 2, 3),
(11, '2020-12-20 13:48:26', 11, 3),
(12, '2020-12-20 13:51:36', 0, 4),
(13, '2020-12-20 13:56:21', 15, 4),
(14, '2020-12-20 13:58:37', 5, 5),
(15, '2020-12-20 14:00:54', 2, 6),
(16, '2020-12-20 14:03:28', 2, 7),
(17, '2020-12-20 14:04:25', 10, 7),
(18, '2020-12-20 14:06:03', 2, 8),
(19, '2020-12-20 14:06:10', 2, 8),
(20, '2020-12-20 14:15:03', 0, 9),
(21, '2020-12-20 14:15:27', 4, 9),
(22, '2020-12-20 14:39:19', 1, 9),
(31, '2020-12-20 17:05:26', 0, 15),
(30, '2020-12-20 17:03:19', 0, 15),
(32, '2020-12-20 17:20:02', 0, 15),
(33, '2020-12-20 17:27:29', 0, 15),
(34, '2020-12-20 17:30:03', 0, 15),
(35, '2020-12-20 17:35:09', 3, 15),
(36, '2021-01-13 22:44:07', 2, 16),
(37, '2021-01-13 22:46:06', 0, 16),
(38, '2021-01-13 22:46:11', 0, 16),
(39, '2021-01-13 23:06:29', 0, 16),
(40, '2021-01-14 17:40:05', 1, 17),
(41, '2021-01-14 17:40:39', 2, 17),
(42, '2021-01-14 17:41:41', 12, 17),
(43, '2021-01-14 17:42:59', 16, 17),
(44, '2021-01-14 17:43:37', 19, 17),
(45, '2021-01-14 17:43:59', 16, 17),
(46, '2021-01-14 17:44:16', 16, 17),
(47, '2021-01-14 17:44:35', 16, 17),
(48, '2021-01-14 17:45:00', 19, 17),
(49, '2021-01-14 17:45:09', 5, 17),
(50, '2021-01-14 17:45:31', 19, 17),
(51, '2021-01-14 17:45:45', 14, 17),
(52, '2021-01-14 17:46:01', 14, 17),
(53, '2021-01-16 12:44:14', 0, 20),
(54, '2021-01-16 12:46:42', 1, 20),
(55, '2021-01-16 13:13:54', 2, 20),
(56, '2021-01-16 13:14:05', 2, 20),
(57, '2021-01-16 13:15:25', 2, 22),
(58, '2021-01-16 13:15:45', 2, 22),
(59, '2021-01-16 13:16:17', 2, 22),
(60, '2021-01-16 13:16:41', 2, 22),
(61, '2021-01-16 13:16:56', 0, 22),
(62, '2021-01-16 13:18:40', 6, 23),
(63, '2021-01-16 13:20:26', 6, 23),
(64, '2021-01-16 13:20:34', 0, 23),
(65, '2021-01-16 13:20:46', 2, 23),
(68, '2021-01-16 14:08:47', 0, 16),
(69, '2021-01-16 14:12:11', 0, 26),
(70, '2021-01-16 14:13:00', 0, 26),
(71, '2021-01-16 14:13:12', 3, 26),
(73, '2021-01-16 14:47:22', 1, 28),
(74, '2021-01-16 14:48:52', 1, 28),
(75, '2021-01-16 14:50:38', 1, 16),
(77, '2021-01-16 14:59:28', 0, 16),
(78, '2021-01-16 15:01:46', 0, 30),
(79, '2021-01-16 15:02:10', 3, 30),
(80, '2021-01-16 16:44:32', 0, 16),
(81, '2021-01-16 16:45:05', 0, 16),
(82, '2021-01-16 16:47:05', 1, 16),
(83, '2021-01-16 16:47:21', 4, 16);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `statistics`
--

CREATE TABLE `statistics` (
  `id` bigint(20) NOT NULL,
  `added_questions` int(11) DEFAULT NULL,
  `correct_answer` int(11) DEFAULT NULL,
  `current_rank` int(11) DEFAULT NULL,
  `games_number` int(11) DEFAULT NULL,
  `incorrect_answer` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `statistics`
--

INSERT INTO `statistics` (`id`, `added_questions`, `correct_answer`, `current_rank`, `games_number`, `incorrect_answer`, `user_id`) VALUES
(1, 34, 0, 0, 0, 0, 1),
(2, 12, 20, 5, 9, 9, 2),
(3, 12, 10, 3, 2, 2, 3),
(4, 11, 10, 2, 2, 2, 4),
(5, 8, 5, 7, 1, 1, 5),
(6, 20, 2, 15, 1, 1, 6),
(7, 5, 10, 4, 2, 2, 7),
(8, 9, 4, 13, 2, 2, 8),
(9, 9, 5, 8, 3, 3, 9),
(15, 4, 3, 10, 6, 6, 15),
(16, 6, 8, 9, 11, 11, 16),
(17, 29, 117, 1, 13, 13, 17),
(18, 0, 0, 0, 0, 0, 19),
(19, 4, 5, 14, 4, 4, 20),
(20, 0, 0, 0, 0, 0, 21),
(21, 0, 8, 16, 5, 5, 22),
(22, 0, 14, 6, 4, 4, 23),
(23, 0, 0, 0, 0, 0, 24),
(25, 0, 3, 11, 3, 3, 26),
(27, 0, 2, 17, 2, 2, 28),
(29, 1, 3, 12, 2, 2, 30);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `incorrect_login_counter` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `active`, `email`, `incorrect_login_counter`, `login`, `password`, `role`) VALUES
(1, b'1', 'asdf@gmail.com', 0, 'asdf', '$2a$10$4tOW0SpBf53b1fkNfhYBqeiEvY9pZyud1MJDeB.pHAtKxhapXO53e', 'ROLE_ADMIN'),
(2, b'1', 'cfty62@o2.pl', 0, 'cfty', '$2a$10$uYubSlwVQewuRQ7kpIBXdeUnJT9GST/MC/CHp/Ft.MMl4WsnLxqQO', 'ROLE_USER'),
(3, b'1', 'franek21@onet.pl', 0, 'franek', '$2a$10$CMXoPlJefdRDE1EWO26ej.zrjm3OXbZ5KL7.EvP1Wq/8vIGpyve/G', 'ROLE_USER'),
(4, b'1', 'grzegorz@gmail.com', 0, 'Grzegorz', '$2a$10$xR.DyxBOU0304PAYZEYYOuirM2QeAR0iotI8jntJLHUBY1pWvqInm', 'ROLE_USER'),
(5, b'1', 'tom@o2.pl', 0, 'TomekPL', '$2a$10$3gjlR63v7FFwwugKlEKkIOm271SUDC242CMowuQ30blroAIJfs/d6', 'ROLE_USER'),
(6, b'1', 'aerg@gmail.com', 0, 'masterPro', '$2a$10$VaZ/UVwwyAAHO1FIVq7FguZJkVBex6911myImA34exsOSiWq0sx9u', 'ROLE_USER'),
(7, b'1', 'qsdre@interia.pl', 0, 'qsdre', '$2a$10$k7OW4vnXOKWedZ5d46ztyuW7HqoFMmB2Ij045tvkrVvAxlWiRJ29e', 'ROLE_USER'),
(8, b'1', 'okre@onet.pl', 0, 'takO', '$2a$10$M9PqTrvRGDofjNmt/aI0yeFNp34/2mAMVJG.yh0nIdI5qfW.1R8Sa', 'ROLE_USER'),
(9, b'1', 'ewqs@gmail.com', 0, 'git123', '$2a$10$2bG5fbZ8tCPXl0n8LnfJYOcq4iNCUoBJPsUBtKS.9fDT0U4dCGjA2', 'ROLE_USER'),
(16, b'1', 'vbnm@gmail.com', 0, 'vbnm', '$2a$10$.YdNpcCILS1Jwzx8yf0F8uKvvYLn4KWVniw8d/JsbYC5Yi8f6Lx0C', 'ROLE_USER'),
(15, b'1', 'psm20@gmail.com', 0, 'ppsm20', '$2a$10$h2gVLHkvClzsKHaaf.mJrOhKJx8Qq/4zR1vz1.J3zZYh2Zov7bWbO', 'ROLE_USER'),
(17, b'1', 'dwq@vp.pl', 0, 'dwq123', '$2a$10$JDCXG0d6YIL4q4.95JGG7.i9FhpH4yxT.pPEG3bR8VDvsHbuj4Haa', 'ROLE_USER'),
(19, b'1', 'admina@gmail.com', 0, 'admina', '$2a$10$DlUEMKA6tbNT9oNmcnI7O.dhG/KOPWVHedh4yYX55iqu2LHuU0HhW', 'ROLE_ADMIN'),
(20, b'1', 'fred@gmail.com', 0, 'fred46', '$2a$10$aCNUUPabaLjlpitXp3xKIedV8I8EkPBXelEDuIjID2u6NJl.62HKG', 'ROLE_USER'),
(21, b'1', 'admin4321@o2.pl', 0, 'admin', '$2a$10$rwy1TGjcuvHDbOE1a2W8mOQ/FReo9Kr6Vi86G1PIgBkx2qGaBrz6e', 'ROLE_ADMIN'),
(22, b'1', 'anonim32167@onet.pl', 0, 'anonimos', '$2a$10$aLuJWW54F/76fNg4XA3lMenrFLX9JqFOFfJmLVeKOlWsi4fqHeBsK', 'ROLE_USER'),
(23, b'1', 'szefu@gmail.com', 0, 'szef', '$2a$10$ASQjS/j6wKA0wgAgeNfY1.kHeoOh71fKo3fjInI2nJk3PJqYWQRWG', 'ROLE_USER'),
(28, b'1', 'nick@gmail.com', 0, 'nick', '$2a$10$Yi9i5wAKAu1NyMVgf5QuLuUv5kXxlKcdd/3OX2nMZyfatTt4Hxm0m', 'ROLE_USER'),
(26, b'1', 'afrty@gmail.com', 0, 'afrty', '$2a$10$MUd0Gc9hFX0WlJPfHbh.oe0SY00P79nqj27YsALB2oXNr.gpwh.lm', 'ROLE_USER'),
(30, b'1', 'test@gmail.com', 0, 'test123', '$2a$10$bq9xbU39o2tZgcBPrxmIFed0vvJOJQnPCB1IJe0V/yDAlerZE8qKe', 'ROLE_USER');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3erw1a3t0r78st8ty27x6v3g1` (`question_id`);

--
-- Indeksy dla tabeli `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `rates`
--
ALTER TABLE `rates`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKxtl9ahma532if6r68yvgo7ck` (`user_id`);

--
-- Indeksy dla tabeli `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgubpcsln9g1fvbi3f5sgt5def` (`user_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `answers`
--
ALTER TABLE `answers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=669;

--
-- AUTO_INCREMENT dla tabeli `questions`
--
ALTER TABLE `questions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=168;

--
-- AUTO_INCREMENT dla tabeli `rates`
--
ALTER TABLE `rates`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `results`
--
ALTER TABLE `results`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT dla tabeli `statistics`
--
ALTER TABLE `statistics`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
