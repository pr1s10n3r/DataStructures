module ListaZipper where

import qualified Data.Maybe as Maybe
import qualified Data.Set as Set

data Node a = Node { value :: a, next :: Maybe (Node a) } deriving (Show, Eq, Ord)

data LinkedList a = EmptyList | LinkedList { head :: Node a } deriving (Show, Eq, Ord)

insertElement1 :: (Ord a) => a -> LinkedList a -> LinkedList a
insertElement1 x EmptyList = LinkedList (Node x Nothing)
insertElement1 x (LinkedList head) = LinkedList (Node x (Just head))

deleteElement1 :: (Ord a) => a -> LinkedList a -> LinkedList a
deleteElement1 x (LinkedList head) =
    case nextNode of Nothing -> if x == nodeValue
                                    then EmptyList
                                    else LinkedList head
                     Just n  -> if x == nodeValue
                                    then deleteElement1 x (LinkedList n)
                                    else insertElement1 nodeValue (deleteElement1 x (LinkedList n))                
    where
        nodeValue = getNodeValue head
        nextNode  = getNextNode head
        node      = Node nodeValue nextNode

searchElement :: (Ord a) => a -> LinkedList a -> Maybe a
searchElement x (LinkedList (Node value next))
    | x == value = Just x
    | otherwise  = case next of Nothing -> Nothing
                                Just n  -> searchElement x (LinkedList n)

deleteElement2 :: (Ord a) => a -> LinkedList a -> (LinkedList a, Maybe a)
deleteElement2 x xs =
    let
        list = deleteElement1 x xs
        diffList = getListDiff (toList xs) (toList list)
        removed = if (length diffList) == 0 then Nothing else Just (diffList !! 0)
    in
        (list, removed)

getListDiff :: (Ord a) => [a] -> [a] -> [a]
getListDiff xs ys = Set.elems (Set.difference (Set.fromList xs) (Set.fromList ys))

toList :: (Ord a) => LinkedList a -> [a]
toList EmptyList = []
toList (LinkedList (Node nodeValue nextNode)) = case nextNode of Nothing -> nodeValue : toList EmptyList
                                                                 Just n  -> nodeValue : toList (LinkedList n)


getNextNode :: (Ord a) => Node a -> Maybe (Node a)
getNextNode (Node _ x) = if Maybe.isNothing x then Nothing else x

getNodeValue :: (Ord a) => Node a -> a
getNodeValue (Node x _) = x
