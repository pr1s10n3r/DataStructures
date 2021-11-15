import qualified ListaZipper as LEO

import System.IO

insertarElemento :: (Ord a) => a -> LEO.LinkedList a -> LEO.LinkedList a
insertarElemento x xs = LEO.insertElement1 x xs

eliminarElemento1 :: (Ord a) => a -> LEO.LinkedList a -> LEO.LinkedList a
eliminarElemento1 x xs = LEO.deleteElement1 x xs

buscarElemento :: (Ord a) => a -> LEO.LinkedList a -> Maybe a
buscarElemento x xs = LEO.searchElement x xs

eliminarElemento2 :: (Ord a) => a -> LEO.LinkedList a -> (LEO.LinkedList a, Maybe a)
eliminarElemento2 x xs = LEO.deleteElement2 x xs

insertarSubLista :: (Ord a) => LEO.LinkedList a -> LEO.LinkedList a -> LEO.LinkedList a
insertarSubLista xs ys = LEO.insertSubList xs ys

eliminarElementos :: (Ord a) => LEO.LinkedList a -> LEO.LinkedList a -> LEO.LinkedList a
eliminarElementos xs ys = LEO.deleteElements xs ys

main :: IO()
main = do
    contents <- readFile "entrada.in"

    let
        fileLines = lines contents
        linkedList = fromLinesToLinkedList fileLines

    writeFile "salida.out" (LEO.toString linkedList)


fromLinesToLinkedList :: [String] -> LEO.LinkedList Integer
fromLinesToLinkedList x =
    let
        numbers = [read number :: Integer | number <- x]
        orderedNumbers = quickSort numbers
        nodes = LEO.fromList orderedNumbers
    in
        case nodes of Nothing -> LEO.EmptyList
                      Just n  -> LEO.LinkedList n

quickSort :: (Ord a) => [a] -> [a]
quickSort [] = []
quickSort (x:xs) =
    let
        smaller = quickSort [v | v <- xs, v <= x]
        bigger = quickSort [v | v <- xs, v > x]
    in
        smaller ++ [x] ++ bigger
