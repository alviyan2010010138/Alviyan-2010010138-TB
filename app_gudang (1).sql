-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jan 2023 pada 05.40
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_gudang`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_barang`
--

CREATE TABLE `tb_barang` (
  `tanggal` varchar(100) NOT NULL,
  `kode_barang` varchar(100) NOT NULL,
  `nama_barang` varchar(250) NOT NULL,
  `kode_kategori` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_barang`
--

INSERT INTO `tb_barang` (`tanggal`, `kode_barang`, `nama_barang`, `kode_kategori`, `jumlah`, `keterangan`) VALUES
('08-01-2023', 'AD01', 'Komputer', '01', 0, 'ON'),
('10-01-2023', 'AD02', 'Komputer', '02', 5, 'ON'),
('10-01-2023', 'AD03', 'Koputer', '03', 7, 'Cancel');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_brg_keluar`
--

CREATE TABLE `tb_brg_keluar` (
  `tanggal` varchar(100) NOT NULL,
  `id_bk` varchar(100) NOT NULL,
  `gudang` varchar(250) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_brg_keluar`
--

INSERT INTO `tb_brg_keluar` (`tanggal`, `id_bk`, `gudang`, `keterangan`) VALUES
('08-01-2023', 'ID01', 'Gudang Cempaka', 'ON'),
('08-01-2023', 'ID02', 'Gudang kayangan', 'cancel'),
('10-01-2023', 'ID03', 'Gudang Serba Ada', 'ON');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_brg_masuk`
--

CREATE TABLE `tb_brg_masuk` (
  `tanggal` varchar(100) NOT NULL,
  `id_bm` varchar(100) NOT NULL,
  `supplier` varchar(250) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_gudang`
--

CREATE TABLE `tb_gudang` (
  `tanggal` varchar(100) NOT NULL,
  `kode_gudang` varchar(100) NOT NULL,
  `nama_gudang` varchar(250) NOT NULL,
  `alamat` varchar(500) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_gudang`
--

INSERT INTO `tb_gudang` (`tanggal`, `kode_gudang`, `nama_gudang`, `alamat`, `keterangan`) VALUES
('08-01-2023', 'AU01', 'Gudang Cempaka', 'Jl. MAhakam', 'ON '),
('08-01-2023', 'AU02', 'Gudang Kayangan', 'Jl. Barito', 'ON'),
('10-01-2023', 'AU03', 'Gudang Serba Ada', 'Jl. CR', 'ON');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `tanggal` varchar(100) NOT NULL,
  `kode_kategori` varchar(100) NOT NULL,
  `nama_kategori` varchar(250) NOT NULL,
  `keterangan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_kategori`
--

INSERT INTO `tb_kategori` (`tanggal`, `kode_kategori`, `nama_kategori`, `keterangan`) VALUES
('01-12-2016', 'AL01', 'COBA', 'ON'),
('01-12-2017', 'AL02', 'COBA COBA', 'ON'),
('10-01-2023', 'AL03', 'Dicoba', 'ON');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `tanggal` varchar(100) NOT NULL,
  `kode_supplier` varchar(100) NOT NULL,
  `nama_supplier` varchar(250) NOT NULL,
  `notelpon_supplier` varchar(20) NOT NULL,
  `alamat_supplier` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `tb_brg_keluar`
--
ALTER TABLE `tb_brg_keluar`
  ADD PRIMARY KEY (`id_bk`);

--
-- Indeks untuk tabel `tb_brg_masuk`
--
ALTER TABLE `tb_brg_masuk`
  ADD PRIMARY KEY (`id_bm`);

--
-- Indeks untuk tabel `tb_gudang`
--
ALTER TABLE `tb_gudang`
  ADD PRIMARY KEY (`kode_gudang`);

--
-- Indeks untuk tabel `tb_kategori`
--
ALTER TABLE `tb_kategori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indeks untuk tabel `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`kode_supplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
