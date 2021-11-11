module ListaZipper where

import qualified Data.Maybe as Maybe

data Node a = Node { value :: a, next :: Maybe (Node a) } deriving (Show, Eq, Ord)

data LinkedList a = EmptyList | LinkedList { head :: Node a } deriving (Show, Eq, Ord)

insertElement1 :: (Ord a) => a -> LinkedList a -> LinkedList a
insertElement1 x EmptyList = LinkedList (Node x Nothing)
insertElement1 x (LinkedList head) = LinkedList (Node x (Just head))

searchElement :: (Ord a) => a -> LinkedList a -> Maybe a
searchElement x (LinkedList (Node value next))
    | x == value = Just x
    | otherwise  = case next of Nothing -> Nothing
                                Just n  -> searchElement x (LinkedList n)

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


getNextNode :: (Ord a) => Node a -> Maybe (Node a)
getNextNode (Node _ x) = if Maybe.isNothing x then Nothing else x

getNodeValue :: (Ord a) => Node a -> a
getNodeValue (Node x _) = x
