-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29 Mei 2018 pada 16.10
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_java`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_barang`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `laporan_barang` (
`kd_parkir` varchar(11)
,`kd_transaksi` varchar(12)
,`plat_nomor` varchar(12)
,`jenis_kendaraan` varchar(7)
,`jam_masuk` varchar(15)
,`jam_keluar` varchar(15)
,`harga` int(11)
,`bayar` int(11)
,`kembali` int(11)
,`status` varchar(12)
,`tanggal_parkir` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `pengendara`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `pengendara` (
`kd_parkir` varchar(11)
,`plat_nomor` varchar(12)
,`jenis_kendaraan` varchar(7)
,`jam_masuk` varchar(15)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_formpembeli`
--

CREATE TABLE `tb_formpembeli` (
  `no_ktp` int(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `kode_kapal` varchar(50) NOT NULL,
  `jk` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`username`, `password`) VALUES
('abcde', '123454'),
('sechan', 'nuralifhia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pengendara`
--

CREATE TABLE `tb_pengendara` (
  `kd_parkir` varchar(11) NOT NULL,
  `plat_nomor` varchar(12) NOT NULL,
  `jenis_kendaraan` varchar(7) NOT NULL,
  `jam_masuk` varchar(15) NOT NULL,
  `status` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pengendara`
--

INSERT INTO `tb_pengendara` (`kd_parkir`, `plat_nomor`, `jenis_kendaraan`, `jam_masuk`, `status`) VALUES
('KD0002', 'd 3434 g', 'Motor', '19:53:20', 'Tidak Ada'),
('KD0003', 'd 4545 b', 'Mobil', '20:15:09', 'Tidak Ada');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_struk`
--

CREATE TABLE `tb_struk` (
  `kd_parkir` varchar(12) NOT NULL,
  `plat_nomor` varchar(12) NOT NULL,
  `jenis_kendaraan` varchar(8) NOT NULL,
  `jam_masuk` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `kd_transaksi` varchar(12) NOT NULL,
  `kd_parkir` varchar(12) NOT NULL,
  `jenis_kendaraan` varchar(7) NOT NULL,
  `jam_keluar` varchar(15) NOT NULL,
  `jumlah_jam` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL,
  `status` varchar(11) NOT NULL,
  `tanggal_parkir` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`kd_transaksi`, `kd_parkir`, `jenis_kendaraan`, `jam_keluar`, `jumlah_jam`, `harga`, `bayar`, `kembali`, `status`, `tanggal_parkir`) VALUES
('KR0001', 'kd0002', 'Motor', '19:54:21', 1, 2000, 3000, 1000, 'Lunas', '29 May 2018'),
('KR0002', 'kd0003', 'Mobil', '20:15:30', 1, 4000, 5000, 1000, 'Lunas', '29 May 2018');

-- --------------------------------------------------------

--
-- Struktur untuk view `laporan_barang`
--
DROP TABLE IF EXISTS `laporan_barang`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_barang`  AS  select `tb_pengendara`.`kd_parkir` AS `kd_parkir`,`tb_transaksi`.`kd_transaksi` AS `kd_transaksi`,`tb_pengendara`.`plat_nomor` AS `plat_nomor`,`tb_pengendara`.`jenis_kendaraan` AS `jenis_kendaraan`,`tb_pengendara`.`jam_masuk` AS `jam_masuk`,`tb_transaksi`.`jam_keluar` AS `jam_keluar`,`tb_transaksi`.`harga` AS `harga`,`tb_transaksi`.`bayar` AS `bayar`,`tb_transaksi`.`kembali` AS `kembali`,`tb_pengendara`.`status` AS `status`,`tb_transaksi`.`tanggal_parkir` AS `tanggal_parkir` from (`tb_pengendara` join `tb_transaksi` on((`tb_pengendara`.`kd_parkir` = `tb_transaksi`.`kd_parkir`))) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `pengendara`
--
DROP TABLE IF EXISTS `pengendara`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pengendara`  AS  select `tb_pengendara`.`kd_parkir` AS `kd_parkir`,`tb_pengendara`.`plat_nomor` AS `plat_nomor`,`tb_pengendara`.`jenis_kendaraan` AS `jenis_kendaraan`,`tb_pengendara`.`jam_masuk` AS `jam_masuk` from `tb_pengendara` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_formpembeli`
--
ALTER TABLE `tb_formpembeli`
  ADD PRIMARY KEY (`no_ktp`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_pengendara`
--
ALTER TABLE `tb_pengendara`
  ADD PRIMARY KEY (`kd_parkir`);

--
-- Indexes for table `tb_struk`
--
ALTER TABLE `tb_struk`
  ADD PRIMARY KEY (`kd_parkir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
